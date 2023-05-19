package com.weixf.client.converter;

import com.dtflys.forest.converter.ForestConverter;
import com.dtflys.forest.converter.ForestEncoder;
import com.dtflys.forest.utils.ForestDataType;

import java.lang.reflect.Type;
import java.nio.charset.Charset;


/**
 * 自定义一个Protobuf的转换器，并实现ForestConverter接口下的convertToJavaObject方法
 */
public class MyProtobufConverter implements ForestConverter, ForestEncoder {

    /**
     * 将源数据转换为目标类型（Type）的java对象
     */
    @Override
    public Object convertToJavaObject(Object source, Type targetType) {
        return null;
    }

    /**
     * 将源数据转换为目标类型（Class）的java对象
     */
    @Override
    public Object convertToJavaObject(byte[] source, Class targetType, Charset charset) {
        return null;
    }

    /**
     * 将源数据转换为目标类型（Type）的java对象
     */
    @Override
    public Object convertToJavaObject(byte[] source, Type targetType, Charset charset) {
        return null;
    }

    /**
     * 获取当前数据转换器转换类型
     */
    @Override
    public ForestDataType getDataType() {
        return null;
    }
}
