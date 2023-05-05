package com.weixf.client.reqframework;

import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.backend.httpclient.HttpClient;
import com.dtflys.forest.backend.okhttp3.OkHttp3;
import com.weixf.entity.MyUser;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
// 设置该请求接口的后端框架默认为 httpclient
@HttpClient
public interface MyBackendClient2 {


    // 未设置请求的后端，则默认为接口指定的后端框架，即 httpclient
    @Post("/data1")
    String send1(@Body MyUser user);


    // 绑定某一方法请求的后端为 okhttp3
    // 会覆盖掉接口上绑定的后端
    @OkHttp3
    @Post("/data2")
    String send2(@Body MyUser user);

}
