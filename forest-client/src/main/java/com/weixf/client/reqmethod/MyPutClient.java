package com.weixf.client.reqmethod;

import com.dtflys.forest.annotation.Put;
import com.dtflys.forest.annotation.PutRequest;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public interface MyPutClient {

    @Put("http://localhost:8080/hello")
    String simplePut1();

    @PutRequest("http://localhost:8080/hello")
    String simplePut2();

}
