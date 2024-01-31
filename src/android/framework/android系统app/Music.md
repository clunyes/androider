路径 /packages/apps/Music/
MediaPlayer C++实现在libmedia里面，和MediaPlayer.java对应起来，
这两者之间通过jni实现android_media_MediaPlayer.cpp联系起来， setDataSource的时候，MediaPlayer会先获取MediaplayerService，
然后通过service的create创建MediaPlayerService::Client，MediaPlayer中的mPlayer就是创建的MediaPlayerService::Client对象。

```
    BP(binder proxy)和BN(binder native)是通过binder来通信的，
    Bp端可以通过BinderProxy的transact()方法与Bn端发送请求，
    而Bn端通过继承Binder类并重写onTransact()接收并处理来自Bp端的请求。


    Bn意味着Binder Native端，Bp是Binder Proxy端，
    Bn端通过onTransact()方法接收来自Bp端的请求的代码，然后把结果写入reply，Bp端再从reply中读取返回值并返回给调用者。

```