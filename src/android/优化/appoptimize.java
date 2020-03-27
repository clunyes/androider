package android.优化;

public class appoptimize {
    /**
     * 优化的目标
     稳定（内存溢出、崩溃）
     流畅（卡顿）
     耗损（耗电、流量、网络）
     安装包（APK瘦身）
     *
     *
     * 使用一些性能管理工具，tencent matrix  https://github.com/Tencent/matrix#matrix_android_cn
     */
    /**
     * 1. 交互的优化：
     *  过度绘制的优化,
     *  布局中ViewStub,ConstraintLayout的使用
     *  尽可能减少刷新次数，缩小刷新区域
     * 2. 内存leakcanary的优化
     * 3. 网络优化
     *  请求的优化，加gzip压缩
     *  图片请求的优化，glide
     * 4. apk瘦身
     *  resource文件压缩，代码混淆压缩
     */

}
