package network.https;

public class ssl的验证过程 {
    /**
     * 整个流程大概如下：
     * 1.浏览器将自己支持的一套加密规则发送给网站。
     *
     * 2.网站部署了一组SSL秘钥，分私钥和秘钥。
     *
     * 3.网站从浏览器的加密规则中选出一组加密算法与HASH算法，并将自己的身份信息（公钥）以证书的形式发回给浏览器。
     * 证书里面包含了网站地址，加密公钥，以及证书的颁发机构等信息。
     *
     * 4.获得网站证书之后浏览器要做以下工作：
     *
     * a) 验证证书的合法性（颁发证书的机构是否合法，证书中包含的网站地址是否与正在访问的地址一致等），
     * 如果证书受信任，则浏览器栏里面会显示一个小锁头，否则会给出证书不受信的提示。
     *
     * b) 如果证书受信任，或者是用户接受了不受信的证书，浏览器会生成一串随机数的密码，并用证书中提供的公钥加密。
     *
     * c) 使用约定好的HASH计算握手消息，并使用生成的随机数对消息进行加密。这个加密过程是非对称加密，即公钥加密，私钥解密。
     * 私钥只在网站服务器上存储，其他人无法获得这个私钥，也就无法解密。可理解为公钥是锁，私钥是钥匙，
     * 客户端将随机数用公钥锁上，经过网络传输到服务器，整个过程就算有人拦截了信息，由于没有私钥解锁，也就无法解密。
     *
     */
}
