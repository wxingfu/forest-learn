package com.weixf.client.reqbody;

import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.annotation.XMLBody;
import com.weixf.entity.XmlUser;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public interface MyXMLClient {

    /*
     * @XMLBody注解修饰对象
     * 发送XML也非常简单，只要用@XMLBody注解修饰相关参数就可以了，该注解自1.5.0-RC1版本起可以使用。
     */
    /**
     * 被@JSONBody注解修饰的参数会根据其类型被自定解析为XML字符串
     * 其修饰的参数类型必须支持JAXB，可以使用JAXB的注解进行修饰
     * 使用@XMLBody注解时可以省略 contentType = "application/xml"属性设置
     */
    @Post("http://localhost:8080/hello/user")
    String sendXmlMessage(@XMLBody XmlUser user);
    /*
     * POST http://localhost:8080/hello/user
     * HEADER:
     *     Content-Type: application/xml
     * BODY:
     *     <misc><username>foo</username><password>bar</password></misc>
     */


    /*
     * @XMLBody注解修饰字符串
     * @XMLBody支持的另一种形式就是直接传入一个XML字符串
     */
    /**
     * @ XMLBody注解可以修饰一个字符串参数，作为要传输的XML字符串
     */
    @Post("http://localhost:8080/hello/user")
    String sendXmlMessage(@XMLBody String userXml);


    /*
     * Protobuf格式
     * @ProtobufBody 注解修饰 protobuf 生成的数据类为类型的参数
     */
    // @Post("/proto/data")
    // ProtobufProto.MyData protobufTest2(@ProtobufBody ProtobufProto.MyData myData);
    // 调用改方法，会将 myData 数据对象自动转换为 Protobuf 格式字节流
    // 并发送到服务端
    // @ProtobufBody 在默认请情况下会将 Content-Type 设为
    // application/x-protobuf


    /*
     * 若要不想使 Content-Type 为 application/x-protobuf, 可以自行设置
     */
    // @Post("/proto/data")
    // ProtobufProto.MyData protobufTest2(@ProtobufBody ProtobufProto.MyData myData);
    // 调用改方法，会将 myData 数据对象自动转换为 Protobuf 格式字节流
    // 并发送到服务端
    // @ProtobufBody 在默认请情况下会将 Content-Type 设为
    // application/x-protobuf




}
