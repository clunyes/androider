package android.自定义view.measure;

public class measure {
    /**
     * MeasureSpec
     *
     *
     * 1）MeasureSpec概括了从父布局传递给子view布局要求。每一个MeasureSpec代表了宽度或者高度要求，它由size（尺寸）和mode（模式）组成。
     *
     *     2）有三种可能的mode：UNSPECIFIED、EXACTLY、AT_MOST
     *
     *     3）UNSPECIFIED：未指定尺寸模式。父布局没有对子view强加任何限制。它可以是任意想要的尺寸。（笔者注：这个在工作中极少碰到，据说一般在系统中才会用到，后续会讲得很少）
     *
     *     4）EXACTLY：精确值模式。父布局决定了子view的准确尺寸。子view无论想设置多大的值，都将限定在那个边界内。
     *     （笔者注：也就是layout_width属性和layout_height属性为具体的数值，如50dp，或者设置为match_parent，设置为match_parent时也就明确为和父布局有同样的尺寸，
     *     所以这里不要以为笔者搞错了。当明确为精确的尺寸后，其也就被给定了一个精确的边界）
     *
     *     5）AT_MOST：最大值模式。子view可以一直大到指定的值。（
     *     笔者注：也就是其宽高属性设置为wrap_content，那么它的最大值也不会超过父布局给定的值，所以称为最大值模式）
     *
     *     6）MeasureSpec被实现为int型来减少对象分配。该类用于将size和mode元组装包和拆包到int中。
     *
     *     7）分析代码可知，一个MeasureSpec的模式如下所示，int长度为32位置，高2位表示mode，后30位用于表示size
     *
     *
     */
    /**
     * ViewGroup.LayoutParams
     *
     *     1）LayoutParams被view用于告诉它们的父布局它们想要怎样被布局。
     *
     *     2）该LayoutParams基类仅仅描述了view希望宽高有多大。对于每一个宽或者高，可以指定为以下三种值中的一个：MATCH_PARENT,WRAP_CONTENT,an exact number。
     *
     *     3）MATCH_PARENT：意味着该view希望和父布局尺寸一样大，如果父布局有padding，则要减去该padding值。
     *
     *     4）WRAP_CONTENT：意味着该view希望其大小为仅仅足够包裹住其内容即可，如果自己有padding，则要加上该padding值。
     *
     *     5）对ViewGroup不同的子类，也有相应的LayoutParams子类。
     *
     *     6）其width和height属性对应着layout_width和layout_height属性。
     */
}
