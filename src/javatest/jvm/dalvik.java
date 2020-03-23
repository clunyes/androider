package javatest.jvm;

public class dalvik {
    /**
     *
     * 参考：http://www.androidmst.com/1101.html
     *
     * ART模式英文全称为：Android runtime，谷歌Android 4.4系统新增的一种应用运行模式，与传统的Dalvik模式不同，ART模式可以实现更为流畅的安卓系统体验，
     * 对于大家来说，只要明白ART模式可让系统体验更加流畅，不过只有在安卓4.4以上系统中采用此功能。
     *
     *
     *  Dalvik与ART的区别
     *
     * （1）在Dalvik下，应用每次运行都需要通过即时编译器（JIT）将字节码转换为机器码，即每次都要编译加运行，这虽然会使安装过程比较快，
     * 但是会拖慢应用以后每次启动的效率。而在ART 环境中，应用在第一次安装的时候，字节码就会预编译（AOT）成机器码，这样的话，虽然设备和应用的首次启动（安装慢了）会变慢，
     * 但是以后每次启动执行的时候，都可以直接运行，因此运行效率会提高。
     *
     * （2）ART占用空间比Dalvik大（字节码变为机器码之后，可能会增加10%-20%），这也是著名的“空间换时间大法"。
     *
     * （3）预编译也可以明显改善电池续航，因为应用程序每次运行时不用重复编译了，从而减少了 CPU 的使用频率，降低了能耗。
     */
}
