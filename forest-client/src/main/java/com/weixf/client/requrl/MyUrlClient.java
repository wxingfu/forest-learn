package com.weixf.client.requrl;

import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Var;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public interface MyUrlClient {

    /**
     * 整个完整的URL都通过参数传入
     * {0}代表引用第一个参数
     */
    @Get("{0}")
    String send1(String myURL);

    /**
     * 整个完整的URL都通过 @Var 注解修饰的参数动态传入
     */
    @Get("{myURL}")
    String send2(@Var("myURL") String myURL);

    /**
     * 通过参数转入的值作为URL的一部分
     */
    @Get("http://{myURL}/abc")
    String send3(@Var("myURL") String myURL);

    /**
     * 参数转入的值可以作为URL的任意一部分
     */
    @Get("http://localhost:8080/test/{myURL}?a=1&b=2")
    String send4(@Var("myURL") String myURL);


}
