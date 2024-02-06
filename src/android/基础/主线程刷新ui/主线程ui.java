package android.基础.主线程刷新ui;

public class 主线程ui {
    /**
     * 主线程（ui线程刷新）的保证就是checkThread。
     * 子线程也能更新ui，checkThread方法还未检测出来时可以（在activity的oncreate）
     * SurfaceView 可以在子线程中刷新ui
     */

    /**
     * SurfaceView是为什么可以直接子线程绘制呢?
     *
     * SurfaceView与View的区别
     *
     *     1. View的绘图效率不高，主要用于动画变化较少的程序
     *     （android普通窗口的视图绘制机制是一层一层的，任何一个子元素或者是局部的刷新都会导致整个视图结构全部重绘一次，因此效率非常低下）
     *     2. SurfaceView 绘图效率较高，用于界面更新频繁的程序
     *     3. SurfaceView拥有独立的Surface（绘图表面），即它不与其宿主窗口共享同一个Surface。
     *     一般来说，每一个窗口在SurfaceFlinger服务中都对应有一个Layer，用来描述它的绘图表面。
     *     对于那些具有SurfaceView的窗口来说，每一个SurfaceView在SurfaceFlinger服务中还对应有一个独立的Layer或者LayerBuffer，
     *     用来单独描述它的绘图表面，以区别于它的宿主窗口的绘图表面。
     *     因此SurfaceView的UI就可以在一个独立的线程中进行绘制，可以不会占用主线程资源。
     *
     *     4. SurfaceView使用双缓冲机制，播放视频时画面更流畅
     */

    /**
     * 什么是双缓冲机制
     *
     * 在运用时可以理解为：SurfaceView在更新视图时用到了两张 Canvas，一张 frontCanvas 和一张 backCanvas ，每次实际显示的是 frontCanvas ，
     * backCanvas 存储的是上一次更改前的视图。当你在播放这一帧的时候，它已经提前帮你加载好后面一帧了，所以播放起视频很流畅。
     * 当使用lockCanvas（）获取画布时，得到的实际上是backCanvas 而不是正在显示的 frontCanvas ，之后你在获取到的 backCanvas 上绘制新视图，
     * 再 unlockCanvasAndPost（canvas）此视图，那么上传的这张 canvas 将替换原来的 frontCanvas 作为新的frontCanvas ，原来的 frontCanvas 将切换到后台作为 backCanvas 。
     * 例如，如果你已经先后两次绘制了视图A和B，那么你再调用 lockCanvas（）获取视图，获得的将是A而不是正在显示的B，
     * 之后你将重绘的 A 视图上传，那么 A 将取代 B 作为新的 frontCanvas 显示在SurfaceView 上，原来的B则转换为backCanvas。相当与多个线程，交替解析和渲染每一帧视频数据。
     *
     * 使用场景
     *
     * 所以SurfaceView一方面可以实现复杂而高效的UI，另一方面又不会导致用户输入得不到及时响应。常用于画面内容更新频繁的场景，比如游戏、视频播放和相机预览。
     *
     */
}
