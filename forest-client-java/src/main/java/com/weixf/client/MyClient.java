package com.weixf.client;

import com.dtflys.forest.annotation.Request;

public interface MyClient {

    @Request("http://localhost:8088/test/hello-get")
    String helloGet();

}
