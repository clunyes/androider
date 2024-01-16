package android.图片;

public class 图片大小计算 {
    //byte=8bits
    /**
     * 图片内存大小和图片文件占用空间大小是没有必然关系，但是一般来说图片文件大小，图片内存大小就越大。
     * 占用空间是在磁盘上占用的空间，内存大小是加载到内存中占用的内存大小。
     *
     * 现在假如有一个图片是600*800的，文件大小100KB。
     *
     * 图片内存大小的计算公式是 ：图片高度 * 图片宽度 * 一个像素占用的字节数
     *
     * 也就是 600 * 800 * 4 byte = 1875KB = 1.83M
     *
     */

    /**
     * byte = 1B
     */
    /**
     * 在Android中，图片的存放目录和手机的屏幕密度影响图片最终的大小，举个例子：
     *
     * 假设我们的图片放到xhdpi目录下，那么我们本文中的图片占用的内存大小如下：
     *
     * 屏幕密度为2的设备：800 * 600 * 4byte = 1.83M
     *
     * 屏幕密度为3的设备：800 * 1.5 * 600 * 1.5 * 4byte = 1.83 * 2.25M = 4.12M
     *
     */
}
