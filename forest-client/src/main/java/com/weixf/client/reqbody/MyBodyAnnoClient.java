package com.weixf.client.reqbody;

import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.Post;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public interface MyBodyAnnoClient {

    /*
    使用@Body注解修饰参数的方式，将传入参数的数据绑定到 HTTP 请求体中。
    @Body注解修饰的参数一定会绑定到请求体中，不用担心它会出现在其他地方
    */

    /**
     * 默认body格式为 application/x-www-form-urlencoded，即以表单形式序列化数据
     */
    @Post("http://localhost:8080/user")
    String sendPost(@Body("username") String username, @Body("password") String password);



}
