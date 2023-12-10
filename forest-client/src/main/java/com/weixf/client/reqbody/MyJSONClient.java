package com.weixf.client.reqbody;

import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.JSONBody;
import com.dtflys.forest.annotation.Post;
import com.weixf.entity.UserInfo;

import java.util.List;
import java.util.Map;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public interface MyJSONClient {

    /*
     * @JSONBody注解修饰对象
     * 发送JSON非常简单，只要用@JSONBody注解修饰相关参数就可以了，该注解自1.5.0-RC1版本起可以使用。
     * 使用@JSONBody注解的同时就可以省略 contentType = "application/json"属性设置。
     */

    /**
     * 被@JSONBody注解修饰的参数会根据其类型被自定解析为JSON字符串
     * 使用@JSONBody注解时可以省略 contentType = "application/json"属性设置
     */
    @Post("http://localhost:8080/hello/user")
    String helloUser(@JSONBody UserInfo user);
    /*
     * POST http://localhost:8080/hello/user
     * HEADER:
     *     Content-Type: application/json
     * BODY:
     *     {"username": "foo", "password": "bar"}
     */


    /*
     * @JSONBody注解修饰键值对
     * @JSONBody注解可以按键值对拆分成多个参数进行传入，在发送的时候再合成一个完成的JSON字符串：
     */

    /**
     * 按键值对分别修饰不同的参数
     * 这时每个参数前的 @JSONBody 注解必须填上 value 属性或 name 属性的值，作为JSON的字段名称
     */
    @Post("http://localhost:8080/hello/user")
    String helloUser(@JSONBody("username") String username, @JSONBody("password") String password);
    /*
     * POST http://localhost:8080/hello/user
     * HEADER:
     *     Content-Type: application/json
     * BODY:
     *     {"username": "foo", "password": "bar"}
     */


    /*
     * @JSONBody注解修饰集合对象
     * @JSONBody注解也支持Map、List等集合类型参数
     */

    /**
     * 被@JSONBody注解修饰的Map类型参数会被自定解析为JSON字符串
     */
    @Post(url = "http://localhost:8080/hello/user")
    String helloUser(@JSONBody Map<String, Object> user);
    /*
     * Map<String, Object> map = new HashMap<>();
     * map.put("name", "foo");
     * map.put("password", "bar");
     * client.helloUser(map);
     *
     *
     * POST http://localhost:8080/hello/user
     * HEADER:
     *     Content-Type: application/json
     * BODY:
     *     {"username": "foo", "password": "bar"}
     */


    /**
     * 被@JSONBody注解修饰的List类型参数会被自定解析为JSON字符串
     */
    @Post(url = "http://localhost:8080/hello/user-names")
    String helloUserNames(@JSONBody List<String> usernames);
    /*
     * List<String> names = Lists.newArrayList("A", "B", "C");
     * client.helloUserNames(names);
     *
     * POST http://localhost:8080/hello/user
     * HEADER:
     *     Content-Type: application/json
     * BODY:
     *     ["A", "B", "C"]
     */


    /*
     * @JSONBody注解修饰字符串
     * @JSONBody注解还支持字符串类型参数，可以直接传入一个JSON字符串进行传输
     */

    /**
     * 直接修饰一个JSON字符串
     */
    @Post("http://localhost:8080/hello/user")
    String helloUser(@JSONBody String userJson);


    /*
     * @Body注解 + contentType
     * 除了@JSONBody注解，使用@Body注解也可以，
     * 只要将contentType属性或Content-Type请求头指定为application/json便可。
     */
    @Post(
            url = "http://localhost:8080/hello/user",
            contentType = "application/json"
    )
    String send(@Body UserInfo user);
    /*
     * POST http://localhost:8080/hello/user
     * HEADER:
     *     Content-Type: application/json
     * BODY:
     *     {"username": "foo", "password": "bar"}
     */


}
