package sourcecode.glide;

public class glideinto {
    /**
     *  RequestBuilder.into()启动资源加载
     *  return into(glideContext.buildImageViewTarget(view, transcodeClass), null,requestOptions);
     * 生成ViewTarget，带着option，继续into
     *
     * 1：创建请求；
     * 2：判断当前请求是否已经存在，是的话，直接启动请求；
     * 3: 保存当前请求到ViewTarget的Tag中，并将Request添加RequestManager中进行跟踪维护。
     * 关注点在1和3
     *
     * 如何构建一个request(在glide中，request是一个接口)
     * buildRequest
     * buildRequestRecursive（recursive 意思递归）
     *
     * 从方法命名来看，请求不一定只有一个，而是会视情况递归地去构建多个请求，这些请求类型包括：
     * 错误图片请求（正常的请求出错时，如果有配置该请求，则启动该请求）errorRequest
     * 缩略图请求（小图请求，可以较快显示。如有配置，在请求开始时，就会启动）
     * 目标图片请求（目标图片请求，在请求开始时，就是启动）mainRequest
     *
     * request的一个具体实现SingleRequest
     *
     * 将这个请求放到RequestManager的请求队列中，同时发起加载请求。
     * 那么，Glide就通过RequestManager、RequestOption、Request，构建了一个请求序列,并通过监听生命周期来动态管理Request的开启、暂停、恢复、销毁等。
     *
     * 在begin方法中，如果图片显示尺寸有效，会直接调用onSizeReady。否则， 会调用target.getSize，去计算图片尺寸，
     * 计算完毕后，同样会回调onSizeReady方法。
     * onSizeReady--->engine.load(具体过程已写入engineload文章中)
     *
     *
     *
     *
     */
}
