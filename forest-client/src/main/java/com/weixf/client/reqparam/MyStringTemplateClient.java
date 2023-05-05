package com.weixf.client.reqparam;

import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Var;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public interface MyStringTemplateClient {
    /**
     * 直接在url字符串的问号后面部分直接写上 参数名=参数值 的形式
     * 等号后面的参数值部分可以用 {参数序号} 这种字符串模板的形式替代
     * 在发送请求时会动态拼接成一个完整的URL
     * 使用这种形式不需要为参数定义额外的注解
     * <p>
     * 注：参数序号是从 0 开始记的方法参数的序号
     * 0 代表第一个参数，1 代表第二个参数，以此类推
     */
    @Get("http://localhost:8080/abc?a={0}&b={1}&id=0")
    String send1(String a, String b);
    /*// 会对第二个参数 B&c=C 进行URL Encode
    myClient.send1("A", "B&c=C");
    // 产生的URL为
    // http://localhost:8080/abc?a=A&b=B%26c%3DC&id=0*/


    /**
     * 直接在url字符串的问号后面部分直接写上 参数名=参数值 的形式
     * 等号后面的参数值部分可以用 {变量名} 这种字符串模板的形式替代
     * 在发送请求时会动态拼接成一个完整的URL
     * 使用这种方式需要通过 @Var 注解或全局配置声明变量
     */
    @Get("http://localhost:8080/abc?a={a}&b={b}&id=0")
    String send2(@Var("a") String a, @Var("b") String b);
    /*// 会对第二个参数 B&c=C 进行URL Encode
    myClient.send2("A", "B&c=C");
    // 产生的URL为
    // http://localhost:8080/abc?a=A&b=B%26c%3DC&id=0*/


    /**
     * 如果一个一个变量包含多个Query参数，比如: "a=1&b=2&c=3"
     * 为变量 parameters 的字符串值
     * 就用 ${变量名} 这种字符串模板格式
     * 使用这种方式需要通过 @Var 注解或全局配置声明变量
     */
    @Get("http://localhost:8080/abc?${parameters}")
    String send3(@Var("parameters") String parameters);
    /*// 会用参数输入的字符串替换URL中的 ${parameters} 部分
    myClient.send3("a=A&b=B&c=C");
    // 产生的URL为
    // http://localhost:8080/abc?a=A&b=B&c=C*/

}
