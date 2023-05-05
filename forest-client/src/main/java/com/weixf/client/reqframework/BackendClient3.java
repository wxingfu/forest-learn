package com.weixf.client.reqframework;

import com.dtflys.forest.annotation.Backend;
import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.Post;
import com.weixf.entity.MyUser;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
// 设置该请求接口的后端框架默认为 httpclient
@Backend("httpclient")
public interface BackendClient3 {

    // 未设置请求的后端，则默认为接口指定的后端框架，即 httpclient
    @Post("/data1")
    String send1(@Body MyUser user);

    // 绑定请求的后端为 okhttp3
    @Backend("okhttp3")
    @Post("/data2")
    String send2(@Body MyUser user);


    /**
     * 该注解的参数也支持字符串模板，即可以通过全局变量和参数来动态传入
     */
    @Backend("{0}")
    @Post("/data")
    String send(String backend, @Body MyUser user);

}
