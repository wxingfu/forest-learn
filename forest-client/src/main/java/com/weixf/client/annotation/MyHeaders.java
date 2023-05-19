package com.weixf.client.annotation;

import com.dtflys.forest.annotation.Headers;

import java.lang.annotation.*;

/**
 * 用Forest组合注解实现一个自定义的请求头注解
 * 此注解加上了 @Headers 注解，并为注解的参数赋了值
 * 那么以后使用此注解的接口和方法，会自动添加上 @Headers 注解以及它的参数值
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
// 被组合的注解
@Headers({
        "Accept: text/plain",
        "Content-Type: application/json",
        // 在组合注解中可以在模板字符串中引用变量
        // 它会从全局变量或方法的参数中获取变量值
        "Token: ${token}"
})
public @interface MyHeaders {
}
