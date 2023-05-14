package com.weixf.client.requrl;

import com.dtflys.forest.callback.AddressSource;
import com.dtflys.forest.http.ForestAddress;
import com.dtflys.forest.http.ForestRequest;

import java.util.Random;


// 实现 AddressSource 接口
public class MyAddressSource implements AddressSource {

    @Override
    public ForestAddress getAddress(ForestRequest request) {
        // 定义 3 个 IP 地址
        String[] ipArray = new String[]{
                "192.168.0.1",
                "192.168.0.2",
                "192.168.0.3",
        };
        // 随机选出其中一个
        Random random = new Random();
        int i = random.nextInt(3);
        String ip = ipArray[i];
        // 返回 Forest 地址对象
        return new ForestAddress(ip, 80);
    }
}
