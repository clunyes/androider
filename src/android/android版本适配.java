package android;

public class android版本适配 {
    /**
     * Android 6.0 适配
     *
     *正常权限。如果在AndroidManifest.xml列出了正常权限，系统将自动授予该权限。
     *危险权限。如果在AndroidManifest.xml中列出了危险权限，用户必须明确批准您的应用使用这些权限。
     */
    /**
     * Android 7.0 适配
     * 应用间共享文件限制
     *
     * 如果要 在应用间共享文件，可以发送content://URI类型的Uri，并授予URI临时访问权限，进行此授权的最简单方式是使用FileProvider类。
     *
     * Android N关闭了三项系统广播：网络状态变更广播、拍照广播及录像广播。
     * 只有在通过 动态注册 的方式才能收到网络变化的广播，在AndroidManifest.xml中静态的注册的无法收到。
     */
    /**
     * Android 8.0 适配
     * notification 在Android 8.0中所有的通知都需要提供通知渠道，否则，所有通知在8.0系统上都不能正常显示。
     * 取消大部分静态注册广播
     * Android 8.0去除了“允许未知来源”选项。<uses-permission android:name="android.permission.REQUEST_INSTALL_PACKAGES"/>第三方安装应用
     */
    /**
     * Android 9.0 适配
     * Android 9.0限制了明文流量的网络请求，非加密的流量请求都会被系统禁止。
     *
     * 清单文件配置：android:networkSecurityConfig="@xml/network_security_config"
     * 但还是建议都使用https进行传输
     *
     */
    /**
     * android 10.0适配
     * Android Q(10)中的媒体资源读写
     * EditText默认不获取焦点，不自动弹出键盘
     * Android Q开始，公有目录File API都失效，不能直接通过new File(path).exists();判断公有目录文件是否存在
     */
}
