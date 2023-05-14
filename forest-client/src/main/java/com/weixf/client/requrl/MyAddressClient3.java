package com.weixf.client.requrl;

import com.dtflys.forest.annotation.Address;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.http.ForestRequest;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public interface MyAddressClient3 {

    // 也是通过 @Address 注解来绑定动态地址来源
    // 每次调用该方法，都可能是不同的根地址
    @Post("/data")
    @Address(source = MyAddressSource.class)
    ForestRequest<String> sendData();
    /* 若连续调用多次sendData()，则每次请求的URL根地址都可能会不同
     * myClient.sendData(); // 第一次调用, URL: http://192.168.0.2/data
     * myClient.sendData(); // 第二次调用, URL: http://192.168.0.2/data
     * myClient.sendData(); // 第三次调用, URL: http://192.168.0.1/data
     * myClient.sendData(); // 第四次调用, URL: http://192.168.0.3/data
     * myClient.sendData(); // 第五次调用, URL: http://192.168.0.1/data
     */
}
