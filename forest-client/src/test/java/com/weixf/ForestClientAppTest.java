package com.weixf;


import com.weixf.client.MyClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
public class ForestClientAppTest {


    @Resource
    private MyClient myClient;

    @Test
    public void test1() {
        String s = myClient.helloGet();
        log.info("请求接口返回结果：" + s);
    }

}
