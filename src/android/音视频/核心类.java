package android.音视频;

public class 核心类 {
    /**
     * android原生的MediaCodec方案，适配做的不好，有些手机不支持
     *
     * MediaCodec:用于创建视音频编解码器，通过它可以对视音频数据进行编解码操作，它是编解码功能的核心类。
     *
     * MediaMetadataRetriever
     * MediaExtractor:相当于一个reader，它用于读取媒体文件，并提取出其中的视音频数据。
     *
     * MediaMuxer:相当于一个writer，它用于将内存中的视音频数据写到文件中。
     *
     * MediaFormat:媒体格式类，它用于描述媒体的格式参数，如视频帧率、音频采样率等
     */
    /**
     * 对视音频文件进行截取与拼接的主要过程是：先创建视音频编解码器，再分别启动视频线程和音频线程，
     * 以分别对视音频数据进行解码、编码，最后将编码好的数据写入文件。
     */
}
