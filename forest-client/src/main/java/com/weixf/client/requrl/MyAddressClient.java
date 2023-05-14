package com.weixf.client.requrl;

import com.dtflys.forest.annotation.Address;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.http.ForestRequest;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public interface MyAddressClient {

    // 通过 @Address 注解绑定根地址
    // host 绑定到第一个参数， port 绑定到第二个参数
    @Post("/data")
    @Address(host = "{0}", port = "{1}")
    ForestRequest<String> sendHostPort(String host, int port);
    // 若调用 sendHostPort("192.168.0.2", 8080);
    // 则最终产生URL:
    // http://192.168.0.2:8080/data




}
