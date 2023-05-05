可以通过`@Request`、以及`@Get`、`@Post`等请求注解的`data`属性把数据添加到请求体。需要注意的是只有当`type`为`POST`、`PUT`、`PATCH`这类 HTTP Method 时，`data`属性中的值才会绑定到请求体中，而`GET`请求在有些情况会绑定到`url`的参数中。

具体`type`属性和`data`属性数据绑定位置的具体关系如下表：

| type      | `data`属性数据绑定位置 | 支持的`contentType`或`Content-Type`请求头 |
| --------- | ---------------------- | ----------------------------------------- |
| `GET`     | `url`参数部分          | 只有`application/x-www-form-urlencoded`   |
| `POST`    | 请求体                 | 任何`contentType`                         |
| `PUT`     | 请求体                 | 任何`contentType`                         |
| `PATCH`   | 请求体                 | 任何`contentType`                         |
| `HEAD`    | `url`参数部分          | 只有`application/x-www-form-urlencoded`   |
| `OPTIONS` | `url`参数部分          | 只有`application/x-www-form-urlencoded`   |
| `DELETE`  | `url`参数部分          | 只有`application/x-www-form-urlencoded`   |
| `TRACE`   | `url`参数部分          | 只有`application/x-www-form-urlencoded`   |