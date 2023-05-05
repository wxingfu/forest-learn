package com.weixf.client.response;

import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Request;
import com.weixf.entity.UserInfo;

import java.util.Map;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public interface MyResponseClient1 {

    /**
     * 反序列化
     * Forest请求会自动将响应的返回数据反序列化成您要的数据类型。想要接受指定类型的数据需要完成两步操作：
     * 第一步：定义dataType属性
     * dataType属性指定了该请求响应返回的数据类型，目前可选的数据类型有三种: text, json, xml
     * Forest会根据您指定的dataType属性选择不同的反序列化方式。其中dataType的默认值为text，
     * 如果您不指定其他数据类型，那么Forest就不会做任何形式的序列化，并以文本字符串的形式返回给你数据。
     * <p></p>
     * 第二步：指定反序列化的目标类型
     * 反序列化需要一个目标类型，而该类型其实就是方法的返回值类型，如返回值为String就会反序列成String字符串，
     * 返回值为Map就会反序列化成一个HashMap对象，您也可以指定为自定义的Class类型。
     */

    /**
     * dataType为text或不填时，请求响应的数据将以文本字符串的形式返回回来
     */
    @Request(
            url = "http://localhost:8080/text/data",
            dataType = "text"
    )
    String getData1();


    /**
     * 若您指定为json或xml，那就告诉了Forest该请求的响应数据类型为JSON或XML形式的数据，就会以相应的形式进行反序列化。
     * dataType为json或xml时，Forest会进行相应的反序列化
     */
    @Request(
            url = "http://localhost:8080/text/data",
            dataType = "json"
    )
    Map getData2();


    /**
     * Class类型
     * public class User {
     * private String username;
     * private String score;
     * // Setter和Getter ...
     * }
     * 如有上面这样的User类，并把它指定为方法的返回类型，而且相应返回的数据这样一段JSON
     * {"username":  "Foo", "score":  "82"}
     * <p></p>
     * dataType属性指明了返回的数据类型为JSON
     */
    @Get(
            url = "http://localhost:8080/user?id=${0}",
            dataType = "json"
    )
    UserInfo getUser1(Integer id);

    /**
     * 省略dataType属性会自动判断返回的数据格式并进行反序列化
     */
    @Get("http://localhost:8080/user?id=${0}")
    UserInfo getUser2(Integer id);

}
