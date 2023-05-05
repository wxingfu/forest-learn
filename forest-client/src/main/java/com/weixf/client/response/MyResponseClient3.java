package com.weixf.client.response;

import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.JSONBody;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.annotation.Query;
import com.dtflys.forest.http.ForestResponse;
import com.weixf.entity.UserInfo;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public interface MyResponseClient3 {

    /*
     * 返回响应对象
     * 直接用普通的对象类型作为请求方法的返回类型，可以将响应数据方便的反序列化，以满足大部分的需求。但还有很多时候不光需要获取响应内容，也需要得到响应头等信息，这时候就需要 ForestResponse 出场了。
     *
     * 将ForestResponse作为请求方法的返回值类型
     */

    /**
     * ForestResponse 可以作为请求方法的返回类型
     * ForestResponse 为带泛型的类，其泛型参数中填的类作为其响应反序列化的目标类型
     */
    @Post("http://localhost:8080/user")
    ForestResponse<String> postUser(@JSONBody UserInfo user);
    /*
     * TODO: 用ForestResponse对象接到请求响应数据后便可以获取响应内容
     *
     * // 以ForestResponse类型变量接受响应数据
     * ForestResponse<String> response = client.postUser(user);
     *
     * // 用isError方法去判断请求是否失败
     * if (response.isError()) {
     *     ... ...
     * }
     *
     * // 用isSuccess方法去判断请求是否成功
     * if (response.isSuccess()) {
     *     ... ...
     * }
     *
     * // 以字符串方式读取请求响应内容
     * String text = response.readAsString();
     *
     * // getContent方法可以获取请求响应内容文本
     * // 和readAsString方法不同的地方在于，getContent方法不会读取二进制形式数据内容，
     * // 而readAsString方法会将二进制数据转换成字符串读取
     * String content = response.getContent();
     *
     * // 获取反序列化成对象类型的请求响应内容
     * // 因为返回类型为ForetReponse<String>, 其泛型参数为String
     * // 所以这里也用String类型获取结果
     * String result = response.getResult();
     *
     * // 以字节数组的形式获取请求响应内容
     * byte[] byteArray = response.getByteArray();
     *
     * // 以输入流的形式获取请求响应内容
     * InputStream in = response.getInputStream();
     *
     */



    /*
     * 因为ForestResponse为带泛型的类型，其泛型参数可以是任何其他类型，所以可以根据它的泛型参数中的类型不同，而将响应内容反序列化成不同的对象。
     */
    /**
     * ForestResponse 可以作为请求方法的返回类型
     * ForestResponse 为带泛型的类，其泛型参数中填的类作为其响应反序列化的目标类型
     */
    @Get("http://localhost:8080/user")
    ForestResponse<UserInfo> getUser(@Query("id") String userId);
    /*
     * 同样是用ForestResponse类型变量去接受响应数据
     *
     * ForestResponse<User> response = client.postUser(user);
     * // 判断请求是否成功
     * if (response.isSuccess()) {
     *     // 通过getResult方法获取其响应内容反序列化后的结果
     *     // 因为返回类型 ForestResponse<User> 中泛型参数为 User,
     *     // 所以得到反序列化后的对象也是User类型对象
     *     User user = response.getResult();
     * }
     */



}
