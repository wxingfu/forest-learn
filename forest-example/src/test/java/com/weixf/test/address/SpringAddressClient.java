package com.weixf.test.address;

import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.http.ForestRequest;

public interface SpringAddressClient {

    @Get("/")
    ForestRequest<String> testHost();

}
