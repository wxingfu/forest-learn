Forest 使用不同的**请求注解**来标识某个接口方法来进行发送不同类型的请求，其支持的HTTP方法如下表所示:

| HTTP 请求方法 | 请求注解                      | 描述               |
| ------------- | ----------------------------- | ------------------ |
| **GET**       | `@Get`、`@GetRequest`         | 获取资源           |
| **POST**      | `@Post`、`@PostRequest`       | 传输实体文本       |
| **PUT**       | `@Put`、`@PutRequest`         | 上传资源           |
| **HEAD**      | `@HeadRequest`                | 获取报文首部       |
| **DELETE**    | `@Delete`、`@DeleteRequest`   | 删除资源           |
| **OPTIONS**   | `@Options`、`@OptionsRequest` | 询问支持的方法     |
| **TRACE**     | `@Trace`、`@TraceRequest`     | 追踪路径           |
| **PATCH**     | `@Patch`、`@PatchRequest`     | 更新资源的某一部分 |
| **不定方法**  | `@Request`                    | 可动态传入HTTP方法 |