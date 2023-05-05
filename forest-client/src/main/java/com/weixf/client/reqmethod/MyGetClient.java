package com.weixf.client.reqmethod;

import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.GetRequest;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public interface MyGetClient {

    @Get("http://localhost:8080/hello")
    String simpleGet1();

    @GetRequest("http://localhost:8080/hello")
    String simpleGet2();

}
