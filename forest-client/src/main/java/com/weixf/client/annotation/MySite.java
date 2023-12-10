package com.weixf.client.annotation;

import com.dtflys.forest.annotation.Address;
import com.dtflys.forest.annotation.Headers;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Forest 可以同时组合多个注解
 * 如方法使用该自定义的 @MySite 注解
 * 那么就等同使用这里被组合的 @Headers 注解和 @Address 注解
 * 以及它们的参数值
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
// 组合第一个注解
@Headers({"Accept: text/plain", "Content-Type: application/json"})
// 组合第二个注解
// 可以从全局变量或方法参数中获取变量值
@Address(host = "${my-site.host}", port = "${my-site.port}")
public @interface MySite {
}
