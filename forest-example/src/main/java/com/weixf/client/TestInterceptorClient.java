package com.weixf.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.DataParam;
import com.dtflys.forest.annotation.Request;
import com.weixf.interceptors.ApiClientInterceptor;


@BaseRequest(baseURL = "localhost:8080")
public interface TestInterceptorClient {

    @Request(
            url = "/receive-interceptor",
            type = "post",
            dataType = "text",
            interceptor = ApiClientInterceptor.class
    )
    String testInterceptor(@DataParam("username") String username);
}
