package com.weixf.client.reqmethod;

import com.dtflys.forest.annotation.HeadRequest;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public interface MyHeadClient {

    @HeadRequest("http://localhost:8080/hello")
    String simpleHead();

}
