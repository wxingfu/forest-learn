package com.weixf.client.annotation;

import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Var;

/*
 *
 * @author weixf
 * @date 2023-05-19
 */
public interface MyCombineAnnoClient {
    // 该方法使用了自定义的组合注解 @MyHeaders
    // 所以该方法发送的请求会自动添加以下请求头:
    // Accept: text/plain
    // Content-Type: application/json
    // Token: xxx (从形参 token 中传入的值)
    @Get("/data")
    @MyHeaders
    String getData(@Var("token") String token);
}
