package com.weixf.client.reqframework;

import com.dtflys.forest.backend.httpclient.HttpClientProvider;
import com.dtflys.forest.handler.LifeCycleHandler;
import com.dtflys.forest.http.ForestRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClients;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public class MyHttpClientProvider implements HttpClientProvider {

    @Override
    public HttpClient getClient(ForestRequest request, LifeCycleHandler lifeCycleHandler) {
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(700 * 1000)
                .setSocketTimeout(700 * 1000)
                .setConnectionRequestTimeout(700 * 1000)
                .setRedirectsEnabled(false)
                .build();
        return HttpClients.custom()
                .setDefaultRequestConfig(config)
                .build();
    }
}

