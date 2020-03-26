package sourcecode.glide;

public class glidecache {
    /**
     * Glide 的缓存分为两种，一是内存缓存，另一个是硬盘缓存。
     *
     * 默认情况下，Glide 会在开始一个新的图片请求之前检查以下多级的缓存：
     *
     * 活动资源 (Active Resources) - 现在是否有另一个 View 正在展示这张图片？（弱引用缓存）
     * 内存缓存 (Memory cache) - 该图片是否最近被加载过并仍存在于内存中？（LRU缓存）
     * 资源类型（Resource） - 该图片是否之前曾被解码、转换并写入过磁盘缓存？
     * 数据来源 (Data) - 构建这个图片的资源是否之前曾被写入过文件缓存？
     *
     * 前两步检查图片是否在内存中，如果是则直接返回图片。后两步则检查图片是否在磁盘上，以便快速但异步地返回图片。
     * 如果四个步骤都未能找到图片，则Glide会返回到原始资源以取回数据（原始文件，Uri, Url等）。
     *
     * 1，DiskCacheStrategy.NONE// 表示不缓存任何内容

     2，DiskCacheStrategy.DATA// 表示只缓存原始图片

     3，DiskCacheStrategy.RESOURCE// 表示只缓存转换过后的图片

     4，DiskCacheStrategy.ALL // 表示既缓存原始图片，也缓存转换过后的图片

     5，DiskCacheStrategy.AUTOMATIC//表示让Glide根据图片资源智能地选择使用哪一种缓存策略（默认选项）
     */
}