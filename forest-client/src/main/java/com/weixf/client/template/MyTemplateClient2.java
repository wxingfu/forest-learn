package com.weixf.client.template;

import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Var;

public interface MyTemplateClient2 {

    /* TODO:  推荐使用{表达式} */


    /**
     * {表达式}模板参数，在?a={a}的情况下，会被认为是一个Query参数，
     * 即便变量可能包含"1&x=10&y=20"这样多个参数的字符串，也会被转义成一个Query参数
     */
    @Get("http://localhost/data?a={a}&b={b}")
    String getData1(@Var("a") String a, @Var("b") String b);
    /* // 最终产生的URL是
     * // http://localhost/data?a=1%26x%3D10%26y%3D20&b=hello
     * // 也就是只会有 a 和 b 两个Query参数
     * myClient.getData("1&x=10&y=20", "hello");
     */


    /**
     * ${表达式}模板参数，可以认为是一种字符串替换，替换完再对URL参数进行解析，所以一个模板参数引用的变量中可能包含多个参数，也会被解析成多个参数
     */
    @Get("http://localhost/data?a=${a}&b=${b}")
    String getData2(@Var("a") String a, @Var("b") String b);
    /* // 最终产生的URL是
     * // http://localhost/data?a=1&x=10&y=20&b=hello
     * // 也就是只会有 a、x、y、b 四个Query参数
     * myClient.getData("1&x=10&y=20", "hello");
     */


}
