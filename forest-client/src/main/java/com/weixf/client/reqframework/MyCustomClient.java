package com.weixf.client.reqframework;

import com.dtflys.forest.annotation.BackendClient;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.backend.httpclient.HttpClient;
import com.dtflys.forest.backend.okhttp3.OkHttp3;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public interface MyCustomClient {

    /**
     * 自定义MyOkHttpClientProvider
     */
    @Get("/")
    @OkHttp3(client = MyOkHttpClientProvider.class)
    ForestResponse<String> sendData1();


    /**
     * 自定义MyHttpClientProvider
     */
    @Get("/")
    @HttpClient(client = MyHttpClientProvider.class)
    ForestResponse<String> sendData2();


    /**
     * 后端 Client 缓存
     * <p>
     * 为提高 Forest 请求的执行性能，默认情况下，每个请求所对应的后端客户端对象都会被缓存
     * 请求前，会先去缓存中寻找所需的后端 Client 对象实例，如若没有，则新创建一个并放入该请求所对应的缓存中
     * 接口的缓存开关设定如下:
     */
    @Get("/")
    @BackendClient(cache = false)
    // 关闭后端 Client 缓存
    ForestRequest<String> sendData();

}
