package com.weixf.client.intercept;

import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;

/*
 *
 * @author weixf
 * @date 2023-05-19
 */
public class SimpleInterceptor4 implements Interceptor<String> {

    @Override
    public void onSuccess(String data, ForestRequest req, ForestResponse res) {
        Object value1 = req.getAttachment("methodName");  // 获取名称为methodName的Attachment
        Object value2 = req.getAttachment("num");  // 获取名称为num的Attachment
    }
}
