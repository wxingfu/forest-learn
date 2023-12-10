package com.weixf.client.reqbody;

import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.BodyType;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.backend.ContentType;
import com.dtflys.forest.converter.json.FastjsonEncoder;
import com.dtflys.forest.converter.json.ForestJacksonConverter;
import com.dtflys.forest.converter.json.GsonEncoder;
import com.dtflys.forest.converter.json.JacksonEncoder;
import com.weixf.entity.Entry;
import com.weixf.entity.MyData;
import com.weixf.entity.MyXmlData;

import java.util.List;
import java.util.Map;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public interface MyBodyTypeClient {


    /**
     * 请求体类型可以通过@BodyType注解来指定
     * 该方法不设置 Content-Type, 也可以指定 JSON 格式请求体
     */
    @Post(url = "/")
    @BodyType("json")
    String send(@Body("name") String name, @Body("value") Object value);
    /*
     * POST http://localhost:8080/hello/user
     * BODY:
     *     {"name": "foo", "value": "bar"}
     */


    /**
     * @BodyType注解也可用于发送请求体格式与 ContentType 头相异的数据
     * 此请求Content-Type头为 application/json
     * 而请求体的格式却可以是表单格式
     */
    @BodyType("form")
    @Post(url = "/", contentType = "application/json")
    String send2(@Body("name") String name, @Body("value") Object value);
    /*
     * POST http://localhost:8080/hello/user
     * HEADER:
     *     Content-Type: application/json
     * BODY:
     *     name=foo&value=bar
     */


    /**
     * @ BodyType注解同时可以指定Encoder
     * 指定请求体格式为json的同时，指定Encoder为Jackson转换器
     */
    @BodyType(type = "json", encoder = ForestJacksonConverter.class)
    @Post(url = "/", contentType = ContentType.APPLICATION_X_WWW_FORM_URLENCODED)
    String send(@Body Entry entry);


    /*
     * JSON 编码器快捷注解
     * 如果要指定特定JSON转换器为某一请求的Encoder，可以使用对应 JSON 编码器的快捷注解
     */

    /**
     * 指定 Fastjson 为 Encoder
     */
    @FastjsonEncoder
    @Post("/")
    String sendFastjson(@Body Entry entry);

    /**
     * 指定 Jackson 为 Encoder
     */
    @JacksonEncoder
    @Post("/")
    String sendJackson(@Body Entry entry);

    /**
     * 指定 Gson 为 Encoder
     */
    @GsonEncoder
    @Post("/")
    String sendGson(@Body Entry entry);

    /*
     * ================================================================================================
     */

    /*
     * 反序列化
     * 反序列化则是正好与序列化的逆过程，是将远端服务接受到的原始数据格式（如：JSON、XML、Protobuf 等）转换为在 Java 程序中可以方便读取操作的 Java 数据对象
     *
     * Forest 提供了多种反序列化的方式
     */

    /**
     * 自动识别结果数据类型
     * Forest 会将根据返回结果自动识别响应的数据格式，并进行反序列化转换
     */

    // 如结果是一串类似 {"a": 1, "b": 2} 形式的JSON字符串
    // 则会自动识别并进行转换
    @Get("http://localhost:8080/data")
    Map getDataAsMap();  // 自动识别转换为 Map 对象

    @Get("http://localhost:8080/data")
    MyData getMyData();  // 自动识别转换为自定义类型对象

    // 如结果是一串 XML 字符串
    // 也能自动识别并转换
    // 但前提是自定义的类型要有 JAXB 注解标注
    MyXmlData getXmlData();

    // 如果结果是一串类似 [{"name": "xxx"}, {"name": "yyy"}] 格式的 JSON 数组字符串
    // Forest 也一样能自动识别并转换为 Java 集合对象
    @Get("http://localhost:8080/data/list")
    List<MyData> getDataList();


    /**
     * Decoder
     * Forest 也可以通过请求注解 (诸如：@Request、@Get、@Post 等) 的decoder属性来指定具体处理该请求结果的反序列化的转换器
     */
    // 指定由 Jackson 转换器处理请求的反序列化
    @Get(
            url = "http://localhost:8080/data",
            decoder = ForestJacksonConverter.class
    )
    Map getData();


}
