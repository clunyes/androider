package android.自定义view;

public class 前言 {
    /**
     *  我们知道，在自定义View的时候一般需要重写父类的onMeasure()、onLayout()、onDraw()三个方法，来完成视图的展示过程。
     *  当然，这三个暴露给开发者重写的方法只不过是整个绘制流程的冰山一角，更多复杂的幕后工作，都让系统给代劳了。一个完整的绘制流程包括measure、layout、draw三个步骤，其中：
     *
     *  measure：测量。系统会先根据xml布局文件和代码中对控件属性的设置，来获取或者计算出每个View和ViewGrop的尺寸，并将这些尺寸保存下来。
     *
     *  layout：布局。根据测量出的结果以及对应的参数，来确定每一个控件应该显示的位置。
     *
     *  draw：绘制。确定好位置后，就将这些控件绘制到屏幕上。
     *
     *
     *  ViewRootImpl:performTraversals(---performMeasure---performLayout---performDraw)
     *
     * 1）performMeasure()：从根节点向下遍历View树，完成所有ViewGroup和View的测量工作，计算出所有ViewGroup和View显示出来需要的高度和宽度；
     * 2）performLayout()：从根节点向下遍历View树，完成所有ViewGroup和View的布局计算工作，根据测量出来的宽高及自身属性，计算出所有ViewGroup和View显示在屏幕上的区域；
     * 3）performDraw()：从根节点向下遍历View树，完成所有ViewGroup和View的绘制工作，根据布局过程计算出的显示区域，将所有View的当前需显示的内容画到屏幕上。
     */
}
