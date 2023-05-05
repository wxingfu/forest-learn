package com.weixf.client.reqbody;

import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.annotation.Var;

import java.io.File;
import java.io.InputStream;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public interface MyBinaryClient {

    /*
     * 对于application/otect-stream等二进制形式的Body数据，直接用 @Body 注解修饰参数即可。
     *
     * 现在支持的二进制 Content-Type 有：
     *
     * application/octect-stream
     * image/* (包括 image/png, image/jpeg 等)
     */

    /**
     * 发送Byte数组类型数据
     */
    @Post(
            url = "/upload/${filename}",
            contentType = "application/octet-stream"
    )
    String sendByteArryr(@Body byte[] body, @Var("filename") String filename);

    /**
     * 发送File类型数据
     */
    @Post(
            url = "/upload/${filename}",
            contentType = "application/octet-stream"
    )
    String sendFile(@Body File file, @Var("filename") String filename);

    /**
     * 发送输入流类型数据
     */
    @Post(
            url = "/upload/${filename}",
            contentType = "application/octet-stream"
    )
    String sendInputStream(@Body InputStream inputStream, @Var("filename") String filename);




}
