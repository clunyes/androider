package android.热修复.不同方案;

public class tinker {
    /**
     * qq空间的方式是全量替换dex，
     * tinker采用差分算法生成patch.dex，在手机上这个patch.dex又会和原有的class.dex 合并生成新的文件fix_class.dex
     *
     * Tinker 定位是热更新，支持类替换、so替换、资源替换，重启后生效。
     *
     * 我注：tinker 的维护成本是很高的，bakApk文件目录是需要保存本地的，每次热修复都要用到。
     * 配置比较复杂，不适合小白
     *
     * 这种更适合做轻量级的更新
     */
}
