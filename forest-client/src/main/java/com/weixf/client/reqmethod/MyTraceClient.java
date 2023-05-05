package com.weixf.client.reqmethod;

import com.dtflys.forest.annotation.Trace;
import com.dtflys.forest.annotation.TraceRequest;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public interface MyTraceClient {

    @Trace("http://localhost:8080/hello")
    String simpleTrace1();

    @TraceRequest("http://localhost:8080/hello")
    String simpleTrace2();

}
