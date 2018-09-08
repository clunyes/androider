package sourcecode.glide;

public class glidecache {
    /**
     * Glide 的缓存分为两种，一是内存缓存，另一个是硬盘缓存。
     * 1. 内存缓存：在默认情况下，Glide自动开启内存缓存的
     *
     * 2. 磁盘缓存：
     * Glide缓存的资源分为两种（1，原图（SOURCE）原始图片   2，处理图（RESULT）经过压缩和变形等转化的图片）
     * 硬盘缓存分为五种，具体看一面。可以通过调用diskCacheStrategy()方法并传入五种不同的参数
     *
     * 1，DiskCacheStrategy.NONE// 表示不缓存任何内容

     2，DiskCacheStrategy.DATA// 表示只缓存原始图片

     3，DiskCacheStrategy.RESOURCE// 表示只缓存转换过后的图片

     4，DiskCacheStrategy.ALL // 表示既缓存原始图片，也缓存转换过后的图片

     5，DiskCacheStrategy.AUTOMATIC//表示让Glide根据图片资源智能地选择使用哪一种缓存策略（默认选项）
     */
}
