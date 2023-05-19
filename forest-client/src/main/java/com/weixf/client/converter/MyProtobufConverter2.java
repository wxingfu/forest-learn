package com.weixf.client.converter;

import com.dtflys.forest.converter.ForestConverter;
import com.dtflys.forest.converter.ForestEncoder;
import com.dtflys.forest.utils.ForestDataType;

import java.lang.reflect.Type;
import java.nio.charset.Charset;

/*
 *
 * @author weixf
 * @date 2023-05-19
 */
public class MyProtobufConverter2 implements ForestConverter, ForestEncoder {
    /**
     * 将源数据转换为目标类型（Type）的java对象
     *
     * @param source     源数据
     * @param targetType 目标类型 (Type对象)
     * @return 转换后的目标类型对象
     */
    @Override
    public Object convertToJavaObject(Object source, Type targetType) {
        return null;
    }

    /**
     * 将源数据转换为目标类型（Class）的java对象
     *
     * @param source     源数据
     * @param targetType 目标类型 (Class对象)
     * @param charset    字符集
     * @return 转换后的目标类型对象
     */
    @Override
    public Object convertToJavaObject(byte[] source, Class targetType, Charset charset) {
        return null;
    }

    /**
     * 将源数据转换为目标类型（Type）的java对象
     *
     * @param source     源数据
     * @param targetType 目标类型 (Type对象)
     * @param charset    字符集
     * @return 转换后的目标类型对象
     */
    @Override
    public Object convertToJavaObject(byte[] source, Type targetType, Charset charset) {
        return null;
    }

    /**
     * 获取当前数据转换器转换类型
     *
     * @return {@link ForestDataType} 对象实例
     */
    @Override
    public ForestDataType getDataType() {
        return null;
    }
}
