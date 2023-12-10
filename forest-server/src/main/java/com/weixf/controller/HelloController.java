package com.weixf.controller;

import com.weixf.entity.MyResult;
import com.weixf.entity.Result;
import com.weixf.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class HelloController {


    @GetMapping("/hello-get")
    public String test1() {
        log.info("hello-get");
        return "hello-get";
    }


    @PostMapping("/hello-post")
    public String test2() {
        log.info("hello-post");
        return "hello-post";
    }

    @PostMapping("/hello-post2")
    public String test3(String bodyParam) {
        log.info("hello-post2");
        return bodyParam;
    }

    @PostMapping("/hello-post3")
    public MyResult test4() {
        log.info("hello-post3");
        return new MyResult(1, "aaa", "123");
    }


    @PostMapping("/hello-post4")
    public Result<List<User>> test5() {
        log.info("hello-post4");
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "aaa", "123"));
        userList.add(new User(2, "bbb", "1234"));
        userList.add(new User(3, "ccc", "12345"));
        userList.add(new User(4, "ddd", "123456"));
        userList.add(new User(5, "eee", "1234567"));
        userList.add(new User(6, "fff", "12345678"));

        Result<List<User>> result = new Result<>();
        result.setData(userList);
        result.setMsg("ok");
        result.setCode(200);

        return result;
    }

    @PostMapping("/hello-post5")
    public Map<String, Object> test6(@RequestBody String param) {
        log.info("hello-post5");
        log.info(param);
        Map<String, Object> map = new HashMap<>();
        map.put("key", param);
        return map;
    }
}
