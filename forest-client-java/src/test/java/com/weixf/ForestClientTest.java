package com.weixf;

import com.dtflys.forest.Forest;
import com.dtflys.forest.config.ForestConfiguration;
import com.dtflys.forest.http.ForestAsyncMode;
import com.dtflys.forest.retryer.BackOffRetryer;
import com.dtflys.forest.ssl.SSLUtils;
import com.dtflys.forest.utils.TypeReference;
import com.weixf.client.MyClient;
import com.weixf.entity.MyResult;
import com.weixf.entity.Result;
import com.weixf.entity.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;


public class ForestClientTest {

    private final static Logger log = LoggerFactory.getLogger(ForestClientTest.class);


    @Test
    public void test1() {
        ForestConfiguration configuration = Forest.config();
        // 配置后端 HTTP API
        configuration.setBackendName("httpclient");
        // 连接池最大连接数，默认值为500
        configuration.setMaxConnections(123);
        // 每个路由的最大连接数，默认值为500
        configuration.setMaxRouteConnections(222);
        // [自v1.5.22版本起可用] 最大请求等待队列大小
        configuration.setMaxRequestQueueSize(100);
        // [自v1.5.21版本起可用] 最大异步线程数
        configuration.setMaxAsyncThreadSize(300);
        // [自v1.5.22版本起可用] 最大异步线程池队列大小
        configuration.setMaxAsyncQueueSize(16);
        // 请求超时时间，单位为毫秒, 默认值为3000
        configuration.setTimeout(3000);
        // 连接超时时间，单位为毫秒, 默认值为2000
        configuration.setConnectTimeout(2000);
        // 设置重试器
        configuration.setRetryer(BackOffRetryer.class);
        // 请求失败后重试次数，默认为0次不重试
        configuration.setMaxRetryCount(0);
        // 单向验证的HTTPS的默认SSL协议，默认为SSLv3
        configuration.setSslProtocol(SSLUtils.SSL_3);
        // 打开或关闭日志，默认为true
        configuration.setLogEnabled(true);
        // [自v1.5.27版本起可用] 异步模式（默认为 platform）
        configuration.setAsyncMode(ForestAsyncMode.PLATFORM);
        // 添加全局变量
        configuration.setVariableValue("username", "foo");
        configuration.setVariableValue("userpwd", "bar");

        // 实例化Forest请求接口
        MyClient myClient = Forest.client(MyClient.class);
        // 调用Forest请求接口，并获取响应返回结果
        String result = myClient.helloGet();
        // 打印响应结果
        log.info(result);
    }

    /**
     * 以字符串形式接受响应数据
     */
    @Test
    public void test2() {
        // Get请求
        // 并以 String 类型接受数据
        String str = Forest.get("http://localhost:8088/test/hello-get").executeAsString();
        log.info(str);
    }

    /**
     * 以自定义类型形式接受响应数据
     */
    @Test
    public void test3() {
        // Post请求
        // 并以自定义的 MyResult 类型接受
        MyResult myResult = Forest.post("http://localhost:8088/test/hello-post3").execute(MyResult.class);
        log.info(myResult.toString());
    }

    /**
     * 以带复杂泛型参数的类型形式接受响应数据
     */
    @Test
    public void test4() {
        // 通过 TypeReference 引用类传递泛型参数
        // 就可以将响应数据以带复杂泛型参数的类型接受了
        Result<List<User>> userList = Forest
                .post("http://localhost:8088/test/hello-post4")
                .execute(new TypeReference<Result<List<User>>>() {
                });
        String s = userList.toString();
        log.info(s);
    }

    /**
     * 异步请求
     */
    @Test
    public void test5() {
        // 异步 Post 请求
        // 通过 onSuccess 回调函数处理请求成功后的结果
        // 而 onError 回调函数则在请求失败后被触发
        Forest.post("http://localhost:8088/test/hello-post5")
                .async()
                .addBody("a", 1)
                .addBody("b", 2)
                .onSuccess(((data, req, res) -> {
                    // data 为响应成功后返回的反序列化过的数据
                    // req 为Forest请求对象，即 ForestRequest 类实例
                    // res 为Forest响应对象，即 ForestResponse 类实例
                    log.info("ex.toString()");
                    log.info(data.toString());
                }))
                .onError(((ex, req, res) -> {
                    // ex 为请求过程可能抛出的异常对象
                    // req 为Forest请求对象，即 ForestRequest 类实例
                    // res 为Forest响应对象，即 ForestResponse 类实例
                    log.info("ex.toString()");
                    log.info(ex.toString());
                }))
                .execute();

    }


    /**
     * 定义请求的各种参数
     */
    @Test
    public void test6() {
        // 定义各种参数
        // 并以 Map 类型接受
        Map<String, Object> map = Forest.post("http://localhost:8088/test/hello-post5")
                .backend("okhttp3")  // 设置后端为 okhttp3
                .host("127.0.0.1")         // 设置地址的host为 127.0.0.1
                .port(8088)                // 设置地址的端口为 8080
                .contentTypeJson()         // 设置 Content-Type 头为 application/json
                .addBody("a", 1)           // 添加 Body 项(键值对)： a, 1
                .addBody("b", 2)           // 添加 Body 项(键值对：  b, 2
                .maxRetryCount(3) // 设置请求最大重试次数为 3
                // 设置 onSuccess 回调函数
                .onSuccess((data, req, res) -> {
                    log.info("success!");
                })
                // 设置 onError 回调函数
                .onError((ex, req, res) -> {
                    log.info("error!");
                })
                // 设置请求成功判断条件回调函数
                .successWhen((req, res) -> res.noException() && res.statusOk())
                // 执行并返回Map数据类型对象
                .executeAsMap();
        log.info(map.toString());
    }
}
