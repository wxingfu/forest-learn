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
public interface MyBackendClient1 {

    // 绑定请求的后端为 httpclient
    @HttpClient
    @Post("/data1")
    String send1(@Body MyUser user);

    // 绑定请求的后端为 okhttp3
    @OkHttp3
    @Post("/data2")
    String send2(@Body MyUser user);

}
