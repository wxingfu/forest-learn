package com.weixf.client.reqframework;

import com.dtflys.forest.backend.okhttp3.OkHttpClientProvider;
import com.dtflys.forest.handler.LifeCycleHandler;
import com.dtflys.forest.http.ForestRequest;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

/*
 * 自定义后端 Client 对象
 * @author weixf
 * @date 2023-05-05
 */
public class MyOkHttpClientProvider implements OkHttpClientProvider {

    @Override
    public OkHttpClient getClient(ForestRequest request, LifeCycleHandler lifeCycleHandler) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(700, TimeUnit.SECONDS)
                .readTimeout(700, TimeUnit.SECONDS)
                .writeTimeout(700, TimeUnit.SECONDS)
                .callTimeout(700, TimeUnit.SECONDS)
                .followSslRedirects(false)
                .retryOnConnectionFailure(false)
                .followRedirects(false)
                .build();
        return okHttpClient;
    }
}

