package com.weixf.client.reqparam;

import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Query;
import com.weixf.entity.UserInfo;

import java.util.Map;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public interface MyQueryAnnoClient {


    // TODO: @Query 注解修饰的参数一定会出现在 URL 中。

    /**
     * 使用 @Query 注解，可以直接将该注解修饰的参数动态绑定到请求url中
     * 注解的 value 值即代表它在url的Query部分的参数名
     */
    @Get("http://localhost:8080/abc?id=0")
    String send(@Query("a") String a, @Query("b") String b);

    /*
    TODO: 注意
        (1) 需要单个单个定义 参数名=参数值 的时候，@Query注解的value值一定要有，比如 @Query("name") String name
        (2) 需要绑定对象的时候，@Query注解的value值一定要空着，比如 @Query User user 或 @Query Map map
    */

    /**
     * 使用 @Query 注解，可以修饰 Map 类型的参数
     * 很自然的，Map 的 Key 将作为 URL 的参数名， Value 将作为 URL 的参数值
     * 这时候 @Query 注解不定义名称
     */
    @Get("http://localhost:8080/abc?id=0")
    String send1(@Query Map<String, Object> map);


    /**
     * @Query 注解也可以修饰自定义类型的对象参数
     * 依据对象类的 Getter 和 Setter 的规则取出属性
     * 其属性名为 URL 参数名，属性值为 URL 参数值
     * 这时候 @Query 注解不定义名称
     */
    @Get("http://localhost:8080/abc?id=0")
    String send2(@Query UserInfo user);


}
