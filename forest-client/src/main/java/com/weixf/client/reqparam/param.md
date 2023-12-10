URL参数，也称为 URL 查询字符串，即跟在 URL 地址中`?`后面的那串字符串，可以用`=`表示一对键值对，多个键值对用`&`隔开，其可以作为
HTTP 请求的参数

## 字符串模板传参

HTTP的`URL`不光有协议名、域名、端口号等等基本信息，更为重要的是它能携带各种参数，称为`Query`参数，它通常包含参数名和参数值两部分。

Forest给`URL`的`Query`部分传参也有多种方式，其中最简洁直白的就数字符串拼接了。

```java
/**
 * 直接在url字符串的问号后面部分直接写上 参数名=参数值 的形式
 * 等号后面的参数值部分可以用 {参数序号} 这种字符串模板的形式替代
 * 在发送请求时会动态拼接成一个完整的URL
 * 使用这种形式不需要为参数定义额外的注解
 * 
 * 注：参数序号是从 0 开始记的方法参数的序号
 * 0 代表第一个参数，1 代表第二个参数，以此类推
 */
@Get("http://localhost:8080/abc?a={0}&b={1}&id=0")
String send1(String a, String b);

/**
 * 直接在url字符串的问号后面部分直接写上 参数名=参数值 的形式
 * 等号后面的参数值部分可以用 {变量名} 这种字符串模板的形式替代
 * 在发送请求时会动态拼接成一个完整的URL
 * 使用这种方式需要通过 @Var 注解或全局配置声明变量
 */
@Get("http://localhost:8080/abc?a={a}&b={b}&id=0")
String send2(@Var("a") String a, @Var("b") String b);


/**
 * 如果一个一个变量包含多个Query参数，比如: "a=1&b=2&c=3"
 * 为变量 parameters 的字符串值
 * 就用 ${变量名} 这种字符串模板格式
 * 使用这种方式需要通过 @Var 注解或全局配置声明变量
 */
@Get("http://localhost:8080/abc?${parameters}")
String send3(@Var("parameters") String parameters);
```

调用`{参数序号}`字符串模板的方法

```java
// 会对第二个参数 B&c=C 进行URL Encode
myClient.send1("A", "B&c=C");

// 产生的URL为
// http://localhost:8080/abc?a=A&b=B%26c%3DC&id=0
```

调用`{变量名}`字符串模板的方法

```java
// 会对第二个参数 B&c=C 进行URL Encode
myClient.send2("A", "B&c=C");

// 产生的URL为
// http://localhost:8080/abc?a=A&b=B%26c%3DC&id=0
```

调用`${变量名}`字符串模板的方法

```java
// 会用参数输入的字符串替换URL中的 ${parameters} 部分
myClient.send3("a=A&b=B&c=C");

// 产生的URL为
// http://localhost:8080/abc?a=A&b=B&c=C
```

## @Query 注解

但把所有`Query`参数直接写在`url`属性的字符串里面是不是也太简单粗暴了，有没有优雅点的方式？有的。

```java
/**
 * 使用 @Query 注解，可以直接将该注解修饰的参数动态绑定到请求url中
 * 注解的 value 值即代表它在url的Query部分的参数名
 */
@Get("http://localhost:8080/abc?id=0")
String send(@Query("a") String a, @Query("b") String b);
```

友情提示

@Query 注解修饰的参数一定会出现在 URL 中。

若是要传的`URL`参数太多了呢？难道要我在方法上定义十几二十个`@Query`修饰的参数？那也太难看了吧。别急，Forest还是有办法让您变的代码变得优雅的。

```java
/**
 * 使用 @Query 注解，可以修饰 Map 类型的参数
 * 很自然的，Map 的 Key 将作为 URL 的参数名， Value 将作为 URL 的参数值
 * 这时候 @Query 注解不定义名称
 */
@Get("http://localhost:8080/abc?id=0")
String send1(@Query Map<String, Object> map);


/**
 * @Query 注解也可以修饰自定义类型的对象参数
 * 依据对象类的 Getter 和 Setter 的规则取出属性
 * 其属性名为 URL 参数名，属性值为 URL 参数值
 * 这时候 @Query 注解不定义名称
 */
@Get("http://localhost:8080/abc?id=0")
String send2(@Query UserInfo user);
```

是不是瞬间简洁不少，但用`@Query`注解绑定参数的时候也有需要注意的地方：

注意

- (1) 需要单个单个定义 `参数名=参数值` 的时候，@Query注解的value值一定要有，比如 @Query("name") String name
- (2) 需要绑定对象的时候，@Query注解的value值一定要空着，比如 @Query User user 或 @Query Map map

## 数组参数

有些时候，需要通过URL参数传递一个数组或者一个列表

**列表类型参数**

```java
/*
 * 接受列表参数为URL查询参数
 */
@Get("http://localhost:8080/abc")
String send1(@Query("id") List idList);
```

若调用 **send1(Arrays.asList(1, 2, 3, 4))**

则产生的最终URL为

```text
http://localhost:8080/abc?id=1&id=2&id=3&id=4
```

**数组类型参数**

```java
/*
 * 接受数组参数为URL查询参数
 */
@Get("http://localhost:8080/abc")
String send2(@Query("id") int[] idList);
```

若调用 **send2(new int[] {1, 2, 3, 4})**

则产生的最终URL为

```text
http://localhost:8080/abc?id=1&id=2&id=3&id=4
```

## 带 [] 的数组参数

有些场景用带方括号(**[]**)的参数名来表示数组类型的 Query 参数

```java
/*
 * 在 @Query 注解的参数名后跟上 [] 即可
 */
@Get("http://localhost:8080/abc")
String send(@Query("id[]") int[] idList);
```

若调用 **send2(new int[] {1, 2, 3, 4})**

则产生的最终URL为

```text
http://localhost:8080/abc?id[]=1&id[]=2&id[]=3&id[]=4
```

## 带下标的数组参数

在字符串模板中引用内置变量`_index`

```java
/*
 * 内置变量 _index 代表数组的下标
 */
@Get("http://localhost:8080/abc")
String send(@Query("id[${_index}]") int[] idList);
```

若调用 **send2(new int[] {1, 2, 3, 4})**

则产生的最终URL为

```text
http://localhost:8080/abc?id[0]=1&id[1]=2&id[2]=3&id[3]=4
```

## JSON参数

如果不想以URL参数的标准格式传递列表或者数组，JSON字符串也是一种选择

这时，可以使用`@JSONQuery`注解

```java
@Get("http://localhost:8080/abc")
String send(@JSONQuery("id") List idList);
```

若调用 **send(Arrays.asList(1, 2, 3, 4))**

则产生的最终URL为

```text
http://localhost:8080/abc?id=[1, 2, 3, 4]
```