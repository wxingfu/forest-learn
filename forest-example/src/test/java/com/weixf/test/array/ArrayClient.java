package com.weixf.test.array;

import com.dtflys.forest.annotation.Address;
import com.dtflys.forest.annotation.Get;

@Address(port = "{port}")
public interface ArrayClient {

    @Get("/com/weixf/test")
    String arrayQueryFromProperties();

}
