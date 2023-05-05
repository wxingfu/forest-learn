package com.weixf.client.reqinterface;

import com.dtflys.forest.annotation.Address;
import com.dtflys.forest.annotation.Backend;
import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.Post;
import com.weixf.entity.MyData;

/*
 * 方法注解
 * 在 Forest 中，方法注解（除了@Post这类请求注解之外）也可以放置在 interface 接口上，其注解效果会涵盖接口下的所有方法
 * 如果方法上有同样的注解，则会覆盖接口上注解的配置信息
 * @author weixf
 * @date 2023-05-05
 */


/**
 * @ Backend 是一个方法维度的注解，但也可以挂在接口上
 * 它可以为接口下的每一个方法请求设置HTTP后端框架
 * 所以该接口下所有请求默认都会使用 OkHttp3
 */
@Backend("okhttp3")
@Address(host = "localhost", port = "8080")
public interface MyInterfaceClient3 {

    /**
     * 使用接口默认后端框架，即 OkHttp3
     */
    @Post("/data1")
    String sendData1(@Body MyData data);

    /**
     * 使用接口默认后端框架，即 OkHttp3
     */
    @Post("/data2")
    String sendData2(@Body MyData data);

    /**
     * 使用了接口上相同的注解 @Backend
     * 覆盖了改接口默认后端框架配置
     * 所以该请求会使用 HttpClient 作为后端框架
     */
    @Backend("httpclient")
    @Post("/data3")
    String sendData3(@Body MyData data);


}
