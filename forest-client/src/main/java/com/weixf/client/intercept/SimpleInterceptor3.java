package com.weixf.client.intercept;

import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.interceptor.Interceptor;
import com.dtflys.forest.reflection.ForestMethod;

/*
 *
 * @author weixf
 * @date 2023-05-19
 */
public class SimpleInterceptor3 implements Interceptor<String> {

    @Override
    public void onInvokeMethod(ForestRequest req, ForestMethod method, Object[] args) {
        String methodName = method.getMethodName();
        req.addAttachment("methodName", methodName); // 添加Attachment
        req.addAttachment("num", args[0]); // 添加Attachment
    }
}
