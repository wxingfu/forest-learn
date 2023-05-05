package com.weixf.client.reqhead;

import com.dtflys.forest.annotation.Header;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.annotation.Request;
import com.dtflys.forest.annotation.Var;
import com.weixf.entity.MyHeaderInfo;

import java.util.Map;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public interface MyHeaderClient {

    @Request(
            url = "http://localhost:8080/hello/user",
            headers = {
                    "Accept-Charset: utf-8",
                    "Content-Type: text/plain"
            }
    )
    String multipleHeaders();


    /**
     * 每次请求传入不同的请求头内容，可以在headers属性的请求头定义中加入数据绑定
     */
    @Request(
            url = "http://localhost:8080/hello/user",
            headers = {
                    "Accept-Charset: ${encoding}",
                    "Content-Type: text/plain"
            }
    )
    String bindingHeader(@Var("encoding") String encoding);


    /**
     * 使用 @Header 注解将参数绑定到请求头上
     *
     * @Header 注解的 value 指为请求头的名称，参数值为请求头的值
     * @Header("Accept") String accept将字符串类型参数绑定到请求头 Accept 上
     * @Header("accessToken") String accessToken将字符串类型参数绑定到请求头 accessToken 上
     */
    @Post("http://localhost:8080/hello/user?username=foo")
    void postUser(@Header("Accept") String accept, @Header("accessToken") String accessToken);


    /**
     * 使用 @Header 注解可以修饰 Map 类型的参数
     * Map 的 Key 指为请求头的名称，Value 为请求头的值
     * 通过此方式，可以将 Map 中所有的键值对批量地绑定到请求头中
     */
    @Post("http://localhost:8080/hello/user?username=foo")
    void headHelloUser(@Header Map<String, Object> headerMap);


    /**
     * 使用 @Header 注解可以修饰自定义类型的对象参数
     * 依据对象类的 Getter 和 Setter 的规则取出属性
     * 其属性名为 URL 请求头的名称，属性值为请求头的值
     * 以此方式，将一个对象中的所有属性批量地绑定到请求头中
     */
    @Post("http://localhost:8080/hello/user?username=foo")
    void headHelloUser(@Header MyHeaderInfo headersInfo);

    /*
    TODO:注意
        (1) 需要单个单个定义请求头的时候，@Header注解的value值一定要有，比如 @Header("Content-Type") String contentType
        (2) 需要绑定对象的时候，@Header注解的value值一定要空着，比如 @Header MyHeaders headers 或 @Header Map headerMap
    */
}
