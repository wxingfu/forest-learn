package com.weixf.client.intercept;

import com.dtflys.forest.annotation.Request;

public interface SimpleClient {

    /**
     * \@Request注解配置拦截器
     */
    @Request(url = "http://localhost:8080/hello/user?username=foo", headers = {"Accept:text/plain"},
            interceptor = SimpleInterceptor.class)
    String simple();


    /**
     * \@Request注解配置多个拦截器
     */
    @Request(url = "http://localhost:8080/hello/user?username=foo", headers = {"Accept:text/plain"},
            interceptor = {SimpleInterceptor.class, SimpleInterceptor2.class})
    String simple2();
}
