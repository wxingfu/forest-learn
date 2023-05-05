package com.weixf.client.response;

import com.dtflys.forest.annotation.JSONBody;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.callback.OnSuccess;
import com.weixf.entity.UserInfo;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public interface MyResponseClient4 {

    /**
     * 回调函数中获取响应对象
     */
    @Post("http://localhost:8080/user")
    void postUser(@JSONBody UserInfo user, OnSuccess<String> onSuccess);
    // ... ...

    /*client.postUser(user, (String resText, ForestRequest request, ForestResponse response) -> {
        // 在成功接收请求响应后处理
        int status = response.getStatusCode(); // 获取请求响应状态码
        String content = response.getContent(); // 获取请求的响应内容
        String result = response.getResult(); // 获取方法返回类型对应的最终数据结果
    });*/

}
