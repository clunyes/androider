```
public class oAuth2 {
    /**
     +--------+                               +---------------+
     |        |--(A)- Authorization Request ->|   Resource    |
     |        |                               |     Owner     |
     |        |<-(B)-- Authorization Grant ---|               |
     |        |                               +---------------+
     |        |
     |        |                               +---------------+
     |        |--(C)-- Authorization Grant -->| Authorization |
     | Client |                               |     Server    |
     |        |<-(D)----- Access Token -------|               |
     |        |                               +---------------+
     |        |
     |        |                               +---------------+
     |        |--(E)----- Access Token ------>|    Resource   |
     |        |                               |     Server    |
     |        |<-(F)--- Protected Resource ---|               |
     +--------+                               +---------------+
     *
     *
     （A）用户打开客户端以后，客户端请求资源所有者（用户）的授权。
     （B）用户同意给予客户端授权。
     （C）客户端使用上一步获得的授权，向认证服务器申请访问令牌。
     （D）认证服务器对客户端进行认证以后，确认无误，同意发放访问令牌。
     （E）客户端使用访问令牌，向资源服务器申请获取资源。
     （F）资源服务器确认令牌无误，同意向客户端开放资源。
     */

    /**
     * jwt: json web token
     */
}
```