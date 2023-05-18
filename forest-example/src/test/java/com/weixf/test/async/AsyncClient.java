package com.weixf.test.async;

import com.dtflys.forest.annotation.Post;

import java.util.concurrent.Future;

public interface AsyncClient {

    @Post(url = "http://localhost:{port}/", async = true)
    Future<String> postFuture();

}
