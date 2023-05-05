package com.weixf.client.reqmethod;

import com.dtflys.forest.annotation.Options;
import com.dtflys.forest.annotation.OptionsRequest;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public interface MyOptionsClient {

    @Options("http://localhost:8080/hello")
    String simpleOptions1();

    @OptionsRequest("http://localhost:8080/hello")
    String simpleOptions2();

}
