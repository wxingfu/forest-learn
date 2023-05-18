package com.weixf.test.redirect;

import com.dtflys.forest.annotation.Address;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.annotation.Redirection;
import com.dtflys.forest.http.ForestResponse;

@Address(port = "${port}")
public interface SpringRedirectClient {

    @Post("/")
    ForestResponse<String> testRedirect1();

    @Redirection
    @Post("/")
    ForestResponse<String> testRedirect2();

    @Redirection(false)
    @Post("/")
    ForestResponse<String> testRedirect3();


}
