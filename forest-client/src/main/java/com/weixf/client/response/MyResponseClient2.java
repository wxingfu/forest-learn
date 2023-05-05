package com.weixf.client.response;

import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.http.ForestRequest;

/*
 *
 * @author weixf
 * @date 2023-05-05
 */
public interface MyResponseClient2 {

    /*
     * 如果将ForestRequest作为请求方法的返回值类型，调用该方法时不会立即执行请求发送的过程，而是直接返回一个ForestRequest对象。
     *
     * 这样做的好处是，可以延迟发送HTTP请求，并对要即将发送的请求参数做进一步的修改和加工。
     */


    /**
     * Get类型请求，url路径为 /test
     * <p>ForestRequest是带泛型参数的类型
     * <p>泛型参数代表返回的响应数据所期望转化成的类型
     *
     * @return Forest请求对象
     */
    @Get("/test")
    ForestRequest<?> getForestRequest();
    /*
     * // 如果请求方法以 ForestRequest 作为返回值类型
     * // 不会直接发送请求
     * // 而是直接返回 Forest 请求对象
     * ForestRequest<?> request = myForestClient.getForestRequest();
     * String path = request.path(); // 得到字符串 /test
     * // 手动执行发送请求，并以字符串形式接受响应数据
     * String ret = request.execute(String.class);
     */

    // TODO: 获得 Forest 请求对象时并不会自动发送请求，需要调用execute()或execute(Class)这类方法手动执行请求发送的过程。
}
