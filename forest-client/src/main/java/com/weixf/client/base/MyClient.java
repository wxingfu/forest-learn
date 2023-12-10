package com.weixf.client.base;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Query;

/**
 * \@BaseRequest 为配置接口层级请求信息的注解
 * 其属性会成为该接口下所有请求的默认属性
 * 但可以被方法上定义的属性所覆盖
 */
@BaseRequest(baseURL = "http://localhost:8080", headers = {"Accept:text/plain"}, sslProtocol = "TLS")
public interface MyClient {

    @Get("/hello/user")
        // http://localhost:8080/hello/user
    String send1(@Query("username") String username);

    @Get("http://www.xxx.com/hello/user")
    String send2(@Query("username") String username);

    @Get(url = "/hello/user", headers = {"Accept:application/json"})
    String send3(@Query("username") String username);
}

