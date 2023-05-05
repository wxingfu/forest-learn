package com.weixf.client.response;

import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;

/*
 *
 * 拦截器中获取响应对象
 * @author weixf
 * @date 2023-05-05
 */
public class SimpleInterceptor1 implements Interceptor<String> {
    // ... ...
    /**
     * 该方法在请求发送之后被调用
     */
    @Override
    public void afterExecute(ForestRequest request, ForestResponse response) {
        // 执行在发送请求之后处理的代码
        int status = response.getStatusCode(); // 获取请求响应状态码
        String content = response.getContent(); // 获取请求的响应内容
        String result = (String) response.getResult(); // 获取方法返回类型对应的最终数据结果
    }
}

