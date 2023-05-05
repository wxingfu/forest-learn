package com.weixf.client.reqinterface;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Query;
import com.dtflys.forest.annotation.Var;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */


/**
 * 若全局变量中已定义 baseUrl 和 accept，
 * 便会将全局变量中的值绑定到 @BaseRequest 的属性中
 */
@BaseRequest(
        baseURL = "${baseUrl}",     // 默认域名
        headers = {
                "Accept:${accept}"      // 默认请求头
        }
)
public interface MyInterfaceClient2 {

    /*
     * @ BaseRequest注解中的所有字符串属性都可以通过模板表达式 (opens new window)引用全局变量 (opens new window)或方法中的参数。
     */

    // 方法的URL的域名将会引用全局变量中定义的 baseUrl
    @Get("/hello/user")
    String send1(@Query("username") String username);

    // @BaseRequest 中的属性亦可以引用方法中的绑定变量名的参数
    @Get("/hello/user")
    String send2(@Var("baseUrl") String baseUrl);
}
