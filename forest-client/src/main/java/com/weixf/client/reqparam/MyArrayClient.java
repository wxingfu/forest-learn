package com.weixf.client.reqparam;

import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.JSONQuery;
import com.dtflys.forest.annotation.Query;

import java.util.List;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public interface MyArrayClient {

    /**
     * 列表类型参数
     * 接受列表参数为URL查询参数
     */
    @Get("http://localhost:8080/abc")
    String send1(@Query("id") List idList);
    // 最终URL：http://localhost:8080/abc?id=1&id=2&id=3&id=4

    /**
     * 数组类型参数
     * 接受数组参数为URL查询参数
     */
    @Get("http://localhost:8080/abc")
    String send2(@Query("id") int[] idList);
    // 最终URL：http://localhost:8080/abc?id=1&id=2&id=3&id=4


    /**
     * 带 [] 的数组参数
     * 在 @Query 注解的参数名后跟上 [] 即可
     */
    @Get("http://localhost:8080/abc")
    String send3(@Query("id[]") int[] idList);
    // 最终URL：http://localhost:8080/abc?id[]=1&id[]=2&id[]=3&id[]=4

    /**
     * 带下标的数组参数
     * 内置变量 _index 代表数组的下标
     */
    @Get("http://localhost:8080/abc")
    String send4(@Query("id[${_index}]") int[] idList);
    // 最终URL：http://localhost:8080/abc?id[0]=1&id[1]=2&id[2]=3&id[3]=4


    /**
     * JSON参数
     */
    @Get("http://localhost:8080/abc")
    String send(@JSONQuery("id") List idList);
    // 最终URL：http://localhost:8080/abc?id=[1, 2, 3, 4]

}
