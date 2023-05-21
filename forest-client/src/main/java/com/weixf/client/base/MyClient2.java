package com.weixf.client.base;

import com.dtflys.forest.annotation.Address;
import com.dtflys.forest.annotation.Backend;
import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.Post;
import com.weixf.entity.MyData;

/**
 * \@Backend 是一个方法维度的注解，但也可以挂在接口上
 * 它可以为接口下的每一个方法请求设置HTTP后端框架
 * 所以该接口下所有请求默认都会使用 OkHttp3
 */
@Backend("okhttp3")
@Address(host = "localhost", port = "8080")
public interface MyClient2 {

    @Post("/data1")
    String sendData1(@Body MyData data);

    @Post("/data2")
    @Address(host = "localhost", port = "8088")
    String sendData2(@Body MyData data);

    @Backend("httpclient")
    @Post("/data3")
    String sendData3(@Body MyData data);
}


