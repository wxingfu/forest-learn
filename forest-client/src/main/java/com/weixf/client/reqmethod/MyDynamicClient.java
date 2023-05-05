package com.weixf.client.reqmethod;

import com.dtflys.forest.annotation.Request;
import com.dtflys.forest.annotation.Var;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public interface MyDynamicClient {

    /**
     * 通过在 @Request 注解的 type 属性中定义字符串模板
     * 在字符串模板中引用方法的参数
     */
    @Request(
            url = "http://localhost:8080/hello",
            type = "{type}"
    )
    String simpleRequest(@Var("type") String type);

    // POST 请求
    // String result1 = simpleRequest("post");
    // DELETE 请求
    // String result2 = simpleRequest("DELETE");

}
