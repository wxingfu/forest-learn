package com.weixf.test.client2;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.LogEnabled;
import com.dtflys.forest.annotation.LogHandler;
import com.dtflys.forest.annotation.Request;
import com.dtflys.forest.http.ForestRequest;
import com.weixf.test.logging.TestLogHandler;
import com.weixf.test.logging.TestLogHandler2;

/**
 * @author gongjun[jun.gong@thebeastshop.com]
 * @since 2018-09-25 18:30
 */
@LogHandler(TestLogHandler2.class)
@LogEnabled(logResponseStatus = true)
@BaseRequest(baseURL = "#{my-site.base-url}")
public interface GiteeClient {

    @Request(
            url = "/dt_flys/#{test.path}",
            timeout = 80000,
            sslProtocol = "SSL"
    )
    @LogHandler(TestLogHandler.class)
    @LogEnabled(logResponseStatus = true, logResponseContent = true)
    ForestRequest<String> index();

    @Request(
            url = "/dt_flys",
            timeout = 80000,
            keyStore = "keystore1"
    )
    ForestRequest<String> index2();


    @Request(
            url = "https://baidu.com/",
            timeout = 80000,
            keyStore = "keystore1"
    )
    String index3();


}
