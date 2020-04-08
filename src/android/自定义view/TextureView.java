package android.自定义view;

public class TextureView {
    /**
     * SurfaceView和TextureView均继承于android.view.View
     *
     * 与其它View不同的是，两者都能在独立的线程中绘制和渲染，在专用的GPU线程中大大提高渲染的性能。
     *
     * 一、SurfaceView专门提供了嵌入视图层级的绘制界面，开发者可以控制该界面像Size等的形式，能保证界面在屏幕上的正确位置。
     * 但也有局限：
     * 由于是独立的一层View，更像是独立的一个Window，不能加上动画、平移、缩放；
     *
     * 二、TextureView更像是一般的View，像TextView那样能被缩放、平移，也能加上动画。
     * TextureView只能在开启了硬件加速的Window中使用，并且消费的内存要比SurfaceView多，并伴随着1-3帧的延迟。
     *
     * 三、TextureView和SurfaceView都是继承自View类的，但是TextureView在Andriod4.0之后的API中才能使用。
     *
     * SurfaceView可以通过SurfaceHolder.addCallback方法在子线程中更新UI，
     * TextureView则可以通过TextureView.setSurfaceTextureListener在子线程中更新UI，
     * 个人认为能够在子线程中更新UI是上述两种View相比于View的最大优势。
     */
}
