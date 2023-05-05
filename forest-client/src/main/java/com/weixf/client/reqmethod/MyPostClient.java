package com.weixf.client.reqmethod;

import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.annotation.PostRequest;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public interface MyPostClient {

    @Post("http://localhost:8080/hello")
    String simplePost1();

    @PostRequest("http://localhost:8080/hello")
    String simplePost2();


}
