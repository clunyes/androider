package android.动态化.热修复.classloader;

public class 热修复原理 {
    /**
     * 说起热修复就不得不提类的加载机制，和常规的JVM类似，在Android中类的加载也是通过ClassLoader来完成，
     * 具体来说就是PathClassLoader 和 DexClassLoader 这两个Android专用的类加载器，这两个类的区别如下：
     *
     *  PathClassLoader：只能加载已经安装到Android系统中的apk文件（/data/app目录），是Android默认使用的类加载器。
     *  DexClassLoader：可以加载任意目录下的dex/jar/apk/zip文件，也就是我们一开始提到的补丁。
     *
     */

}
