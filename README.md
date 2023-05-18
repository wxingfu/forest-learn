# Forest学习


Forest有哪些特性？
-----

* 以Httpclient和OkHttp为后端框架
* 通过调用本地方法的方式去发送Http请求, 实现了业务逻辑与Http协议之间的解耦
* 因为针对第三方接口，所以不需要依赖Spring Cloud和任何注册中心
* 支持所有请求方法：GET, HEAD, OPTIONS, TRACE, POST, DELETE, PUT, PATCH
* 支持文件上传和下载
* 支持灵活的模板表达式
* 支持拦截器处理请求的各个生命周期
* 支持自定义注解
* 支持OAuth2验证
* 支持过滤器来过滤传入的数据
* 基于注解、配置化的方式定义Http请求
* 支持Spring和Springboot集成
* JSON格式数据序列化和反序列化
* XML格式数据序列化和反序列化
* Protobuf格式数据序列化和反序列化
* JSON、XML或其他类型转换器可以随意扩展和替换
* 支持JSON转换框架: Fastjson, Jackson, Gson
* 支持JAXB形式的XML转换
* 可以通过OnSuccess和OnError接口参数实现请求结果的回调
* 配置简单，一般只需要@Request一个注解就能完成绝大多数请求的定义
* 支持异步请求调用