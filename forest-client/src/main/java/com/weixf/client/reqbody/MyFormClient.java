package com.weixf.client.reqbody;

import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.Post;
import com.weixf.entity.UserInfo;

/*
 * 表单格式
 * @author weixf
 * @date 2023-05-05
 */
public interface MyFormClient {

    /*
    @Body 注解的例子用的是普通的表单格式，也就是contentType属性为application/x-www-form-urlencoded的格式，即contentType不做配置时的默认值。
    表单格式的请求体以字符串 key1=value1&key2=value2&...&key{n}=value{n} 的形式进行传输数据，其中value都是已经过 URL Encode 编码过的字符串。
     */
    /**
     * contentType属性设置为 application/x-www-form-urlencoded 即为表单格式，
     * 当然不设置的时候默认值也为 application/x-www-form-urlencoded， 也同样是表单格式。
     * 在 @Body 注解的 value 属性中设置的名称为表单项的 key 名，
     * 而注解所修饰的参数值即为表单项的值，它可以为任何类型，不过最终都会转换为字符串进行传输。
     */
    @Post(
            url = "http://localhost:8080/user",
            contentType = "application/x-www-form-urlencoded"
    )
    String sendPost(@Body("key1") String value1, @Body("key2") Integer value2, @Body("key3") Long value3);
    /*
     * POST http://localhost:8080/hello/user
     * HEADER:
     *     Content-Type: application/x-www-form-urlencoded
     * BODY:
     *     key1=xxx&key2=1000&key3=9999
     */



    /*
    当@Body注解修饰的参数为一个对象，并注解的value属性不设置任何名称的时候，
    会将注解所修饰参数值对象视为一整个表单，
    其对象中的所有属性将按 属性名1=属性值1&属性名2=属性值2&...&属性名{n}=属性值{n} 的形式通过请求体进行传输数据。
     */
    /**
     * contentType 属性不设置默认为 application/x-www-form-urlencoded
     * 要以对象作为表达传输项时，其 @Body 注解的 value 名称不能设置
     */
    @Post("http://localhost:8080/hello/user")
    String send(@Body UserInfo user);
    /* 结果：
     * POST http://localhost:8080/hello/user
     * HEADER:
     *     Content-Type: application/x-www-form-urlencoded
     * BODY:
     *     username=foo&password=bar
     */
}
