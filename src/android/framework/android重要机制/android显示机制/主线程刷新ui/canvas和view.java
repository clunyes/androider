package android.framework.android重要机制.android显示机制.主线程刷新ui;

public class canvas和view {
    /**
     * view的绘制最终会绘制到canvas上
     *
     * PS中的图层可谓PS的精华，它保证了在一个图层中绘制而不会影响到其他的图层
     *  在Canvas中每次的save()都存将先前的状态保存下来，产生一个新的绘图层，
     *  我们可以随心所欲地地画而不会影响其他已画好的图，最后用restore()将这个图层合并到原图层
     *  这像是栈的概念，每次save()，新图层入栈(注意可以save多次)，只有栈顶的层可以进行操作，restore()弹栈
     */
}
