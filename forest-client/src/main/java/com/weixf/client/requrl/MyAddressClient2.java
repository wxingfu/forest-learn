package com.weixf.client.requrl;

import com.dtflys.forest.annotation.Address;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.http.ForestRequest;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
// 整个接口下的所有方法请求都默认绑定该根地址
@Address(host = "127.0.0.1", port = "8080")
public interface MyAddressClient2 {

    // 绑定接口上的默认根地址
    // 最终URL: http://127.0.0.1:8080/data1
    @Post("/data1")
    ForestRequest<String> sendData1();

    // 绑定接口上的默认根地址
    // 最终URL: http://127.0.0.1:8080/data2
    @Post("/data2")
    ForestRequest<String> sendData2();

    // 使用方法上的根地址
    // 最终URL: http://192.168.0.1:7000/data3
    @Post("/data3")
    @Address(host = "192.168.0.1", port = "7000")
    ForestRequest<String> sendData3();
}
