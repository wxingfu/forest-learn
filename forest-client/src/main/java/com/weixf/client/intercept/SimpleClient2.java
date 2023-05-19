package com.weixf.client.intercept;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Request;

/*
 *
 * @author weixf
 * @date 2023-05-19
 */

/**
 * \@BaseRequest注解配置拦截器
 */
@BaseRequest(
        baseURL = "http://localhost:8080",
        interceptor = {SimpleInterceptor.class, SimpleInterceptor2.class}
)
public interface SimpleClient2 {

    @Request(url = "/hello/user1?username=foo")
    String send1();

    @Request(url = "/hello/user2?username=foo")
    String send2();

    @Request(url = "/hello/user3?username=foo")
    String send3();
}
