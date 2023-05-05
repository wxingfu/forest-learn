package com.weixf.client;

import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Query;
import com.dtflys.forest.annotation.Request;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public interface MyClient {

    @Get("http://localhost:8088/test/hello-get")
    String helloGet();


    /**
     * 通过@Request注解，将simpleRequest()方法绑定了一个 HTTP 请求，
     * 其 URL 为http://localhost:8080/hello ，并默认使用GET方式，
     * 且将请求响应的数据以String的方式返回给调用者
     */
    @Request("http://localhost:8080/hello")
    String simpleRequest();

    /**
     * sendRequest方法绑定的 HTTP 请求，定义了 URL 信息，以及把Accept:text/plain加到了请求头中，
     * 方法的参数String username绑定了注解@Query("uname")，
     * 它的作用是将调用者传入入参 username 时，自动将username的值加入到 HTTP 的请求参数uname中
     */
    @Request(
            url = "http://localhost:8080/hello/user",
            headers = "Accept: text/plain"
    )
    String sendRequest(@Query("uname") String username);


}
