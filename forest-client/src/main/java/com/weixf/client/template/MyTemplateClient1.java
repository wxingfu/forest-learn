package com.weixf.client.template;

import com.dtflys.forest.annotation.Request;
import com.dtflys.forest.annotation.Var;

public interface MyTemplateClient1 {


    @Request(url = "http://localhost:8080/hello/{name}")
    String send1(@Var("name") String name);
    // http://localhost:8080/hello/world


    @Request(url = "http://localhost:8080/hello/${name}")
    String send2(@Var("name") String name);

}
