package com.weixf.client.reqmethod;

import com.dtflys.forest.annotation.Delete;
import com.dtflys.forest.annotation.DeleteRequest;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public interface MyDeleteClient {

    @Delete("http://localhost:8080/hello")
    String simpleDelete1();

    @DeleteRequest("http://localhost:8080/hello")
    String simpleDelete2();


}
