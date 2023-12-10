package com.weixf.client.intercept;

import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;
import com.dtflys.forest.reflection.ForestMethod;

/*
 *
 * @author weixf
 * @date 2023-05-19
 */
public class SimpleInterceptor2 implements Interceptor<String> {

    @Override
    public void onInvokeMethod(ForestRequest req, ForestMethod method, Object[] args) {
        String methodName = method.getMethodName();
        addAttribute(req, "methodName", methodName); // 添加Attribute
        addAttribute(req, "num", args[0]); // 添加Attribute
    }

    @Override
    public void onSuccess(String data, ForestRequest req, ForestResponse res) {
        Object value1 = getAttribute(req, "methodName");  // 获取名称为methodName的Attribute，不指定返回类型
        String value2 = getAttribute(req, "methodName", String.class);  // 获取名称为methodName的Attribute，并转换为指定的Class类型
        String value3 = getAttributeAsString(req, "methodName");  // 获取名称为methodName的Attribute，并转换为String类型
        Integer value4 = getAttributeAsInteger(req, "num");  // 获取名称为num的Attribute，并转换为Integer类型
    }
}
