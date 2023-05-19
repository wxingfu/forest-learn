package com.weixf.client.annotation;

import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Var;

/*
 *
 * @author weixf
 * @date 2023-05-19
 */
public interface MyAuthClient {

    /**
     * 在请求接口上加上自定义的 @MyAuth 注解
     * 注解的参数可以是字符串模板，通过方法调用的时候动态传入
     * 也可以是写死的字符串
     */
    @Get(url = "http://localhost:8080/hello/user?username=${username}", headers = {"Accept:text/plain"})
    @MyAuth(username = "${username}", password = "bar")
    String send(@Var("username") String username);

}
