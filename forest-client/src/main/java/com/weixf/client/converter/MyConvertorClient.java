package com.weixf.client.converter;

import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.BodyType;
import com.dtflys.forest.annotation.Get;
import com.weixf.entity.MyData;

// 接口级别转换器定义
@BodyType(type = "protobuf", encoder = MyProtobufConverter.class)
public interface MyConvertorClient {

    // 方法级别转换器定义
    @Get("/data")
    @BodyType(type = "protobuf", encoder = MyProtobufConverter2.class)
    String sendData(@Body MyData data);
}
