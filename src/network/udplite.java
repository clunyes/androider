package network;

public class udplite {
    /**
     * UDP-Lite（Lightweight User Datagram Protocol，轻量级用户数据报协议）是扩展UDP机能的一种传输层协议。
     * 在UDP通信中，如果check sum出现错误，所收到的包将被全部丢弃。然而现实操作中有些应用在面对这种情况时并不希望全部丢弃。
     *
     * 比较简单的想法是直接不检验校验和，但是这种方式如果是首部被破坏，那就会产生安全问题，所以不能直接将校验和去掉。UDP-Lite也就是来处理这种问题。
     * 对数据中不允许发生错误的部分进行检查；对其他部分即使出错也可以忽略不计。
     */

}
