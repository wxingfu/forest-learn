Forest 的配置层级介绍：

全局配置：针对全局所有请求，作用域最大，配置读取的优先级最小。

接口配置： 作用域为某一个interface中定义的请求，读取的优先级最小。您可以通过在interface上修饰@BaseRequest注解进行配置。

请求配置： 作用域为某一个具体的请求，读取的优先级最高。您可以在接口的方法上修饰@Request注解进行 HTTP 信息配置的定义。