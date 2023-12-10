## URL结构

再继续介绍之后的Forest URL相关内容之前，我认为有必要先讲解下URL的标准结构 (已经对此非常了解的小伙伴可以跳过此节)

一个标准的URL一般会包含以下几个部分：

- **协议**: 如URL的协议部分为`http` ，就代表请求使用的是HTTP协议
- **域名**: 如URL的域名部分为`baidu.com`，就代表请求域名地址为`baidu.com`，IP地址和主机名也可以当作域名一样使用
- **端口号**: 跟在域名后面的是端口，域名和端口之间使用`:`
  作为分隔符。端口不是一个URL必须的部分，如果省略端口部分，HTTP协议请求将采用默认端口`80`，HTTPS则用默认端口`443`
- **路径地址**: 路径地址是从域名后的第一个`/`开始，一直到`?`为止的部分，如果没有`?`，则是从域名后的最后一个`/`开始到`#`
  为止的部分，如果没有`？`和`#`，那么从域名后的第一个`/`开始到结束，都是路径地址部分
- **查询参数**: 从`？`开始到`#`为止之间的部分为查询参数部分，又称搜索部分、查询部分
- **锚**: 从`#`开始到最后，都是锚部分

## 根地址

我们都知道，一个URL地址包含协议、站点地址(域名/IP地址/主机名)、端口号、路径地址、查询参数等几个部分。

而协议、站点地址(域名/IP地址/主机名)、端口号这三部分称为根地址。

但如果代码中大量URL接口都来自同一个站点，那就会存在两大重复的域名或IP地址，如果它们都以字符串形式散落在各个Forest请求接口方法的URL属性中，那就会变得难以维护。

### @Address 注解

Forest 从`1.5.3`版本开始提供了 `@Address` 注解，帮助您将URL的地址部分提取出来，方便管理

```java
// 通过 @Address 注解绑定根地址
// host 绑定到第一个参数， port 绑定到第二个参数
@Post("/data")
@Address(host = "{0}", port = "{1}")
ForestRequest<String> sendHostPort(String host, int port);

// 若调用 sendHostPort("192.168.0.2", 8080);
// 则最终产生URL:
// http://192.168.0.2:8080/data
```

`@Address` 注解可以绑定到接口类上，根地址绑定返回就扩展到整个接口下的所有方法

```java
// 整个接口下的所有方法请求都默认绑定该根地址
@Address(host = "127.0.0.1", port = "8080")
public interface MyClient {

    // 绑定接口上的默认根地址
    // 最终URL: http://127.0.0.1:8080/data1
    @Post("/data1")
    ForestRequest<String> sendData1();

    // 绑定接口上的默认根地址
    // 最终URL: http://127.0.0.1:8080/data2
    @Post("/data2")
    ForestRequest<String> sendData2();

    // 使用方法上的根地址
    // 最终URL: http://192.168.0.1:7000/data3
    @Post("/data3")
    @Address(host = "192.168.0.1", port = "7000")
    ForestRequest<String> sendData3();
}
```

### 动态根地址

以上的方法虽然可以方便管理和批量配置多个请求的根地址，但如果想要实时动态地变更根地址就很困难

比如：我想每次发送请求的时候，动态地从3个IP地址中随机选取一个作为根地址，该怎么做呢？

Forest 提供了`地址来源`接口，即`AddressSource`接口来帮您实现该功能

```java
// 实现 AddressSource 接口
public class MyAddressSource implements AddressSource {

    @Override
    public ForestAddress getAddress(ForestRequest request) {
        // 定义 3 个 IP 地址
        String[] ipArray = new String[] {
                "192.168.0.1",
                "192.168.0.2",
                "192.168.0.3",
        };
        // 随机选出其中一个
        Random random = new Random();
        int i = random.nextInt(3);
        String ip = ipArray[i];
        // 返回 Forest 地址对象
        return new ForestAddress(ip, 80);
    }
}
```

绑定自定义的`AddressSource`接口实现类

```java
// 也是通过 @Address 注解来绑定动态地址来源
// 每次调用该方法，都可能是不同的根地址
@Post("/data")
@Address(source = MyAddressSource.class)
ForestRequest<String> sendData();
```

若连续调用多次`sendData()`，则每次请求的URL根地址都可能会不同

```java
myClient.sendData(); // 第一次调用, URL: http://192.168.0.2/data
myClient.sendData(); // 第二次调用, URL: http://192.168.0.2/data
myClient.sendData(); // 第三次调用, URL: http://192.168.0.1/data
myClient.sendData(); // 第四次调用, URL: http://192.168.0.3/data
myClient.sendData(); // 第五次调用, URL: http://192.168.0.1/data
```