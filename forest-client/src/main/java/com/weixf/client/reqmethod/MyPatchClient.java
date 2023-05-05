package com.weixf.client.reqmethod;

import com.dtflys.forest.annotation.Patch;
import com.dtflys.forest.annotation.PatchRequest;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public interface MyPatchClient {

    @Patch("http://localhost:8080/hello")
    String simplePatch1();

    @PatchRequest("http://localhost:8080/hello")
    String simplePatch2();

}
