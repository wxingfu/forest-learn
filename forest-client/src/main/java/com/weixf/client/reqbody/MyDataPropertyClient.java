package com.weixf.client.reqbody;

import com.dtflys.forest.annotation.Request;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public interface MyDataPropertyClient {

    /**
     * data属性在POST请求中绑定请求体
     */
    @Request(
            url = "http://localhost:8080/hello/user",
            type = "post",
            data = "username=foo&password=bar",
            headers = {"Accept:text/plain"}
    )
    String dataPost();
    /*
     * POST http://localhost:8080/hello/user
     * HEADER:
     *     Accept:text/plain
     * BODY:
     *     username=foo&password=bar
     */


    /*
     * 在data属性中进行数据绑定
     */
    /**
     * 这里 data 属性中设置的字符串内容会绑定到请求体中
     * 其中 ${0} 和 ${1} 为参数序号绑定，会将序号对应的参数绑定到字符串中对应的位置
     * ${0} 会替换为 username 的值，${1} 会替换为 password 的值
     */
    @Request(
            url = "http://localhost:8080/hello/user",
            type = "post",
            data = "username=${0}&password=${1}",
            headers = {"Accept:text/plain"}
    )
    String dataPost(String username, String password);
    /*
     * myClient.dataPost("foo", "bar");
     *
     * POST http://localhost:8080/hello/user
     * HEADER:
     *     Accept: text/plain
     * BODY:
     *     username=foo&password=bar
     */


    /**
     * 把 JSON 数据加入到请求体中，其中header设置为Content-Type: application/json
     */
    @Request(
            url = "http://localhost:8080/hello/user",
            type = "post",
            data = "{\"username\": \"${0}\", \"password\": \"${1}\"}",
            headers = {"Content-Type: application/json"}
    )
    String postJson(String username, String password);
    /*
     * myClient.postJson("foo", "bar");
     *
     * POST http://localhost:8080/hello/user
     * HEADER:
     *     Content-Type: application/json
     * BODY:
     *     {"username": "foo", "password": "bar"}
     */


    /**
     *  XML 数据加入到请求体中，其中header设置为Content-Type: application/xml
     */
    @Request(
            url = "http://localhost:8080/hello/user",
            type = "post",
            data = "<misc><username>${0}</username><password>${1}</password></misc>",
            headers = {"Content-Type: application/xml"}
    )
    String postXml(String username, String password);
    /*
     * myClient.postXml("foo", "bar");
     *
     * POST http://localhost:8080/hello/user
     * HEADER:
     *     Content-Type: application/xml
     * BODY:
     *     <misc><username>foo</username><password>bar</password></misc>
     */



}
