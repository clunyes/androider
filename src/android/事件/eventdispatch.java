package android.事件;

public class eventdispatch {
    /**
     * ViewGroup的事件传递方法：
     * onInterceptTouchEvent
     * dispatchTouchEvent
     * onTouchEvent
     *
     * View的事件传递方法：
     * View的dispatchTouchEvent
     * View的onTouchEvent
     *
     * public boolean dispatchTouchEvent(MotionEvent){
     *     boolean consume = false;
     *     if(onInterceptTouchEvent(ev)){
     *         consume = onTouchEvent(ev);
     *     }else{
     *         consume = child.dispatchTouchEvent(ev);
     *     }
     *     return consume;
     * }
     *
     * ViewGroup的dispatchTouchEvent是真正在执行“分发”工作
     *
     * 1.Touch事件分发中只有两个主角:ViewGroup和View。ViewGroup包含onInterceptTouchEvent、dispatchTouchEvent、onTouchEvent三个相关事件。
     * View包含dispatchTouchEvent、onTouchEvent两个相关事件。其中ViewGroup又继承于View。
     *
     * 2.ViewGroup和View组成了一个树状结构，根节点为Activity内部包含的一个ViwGroup。
     *
     * 3.触摸事件由Action_Down、Action_Move、Action_UP组成，其中一次完整的触摸事件中，Down和Up都只有一个，Move有若干个，可以为0个。
     */
    /**
     * 一些注意点
     * （1）. 同一见事件序列是从手指接触屏幕的那一刻起，到手指离开屏幕的那一刻结束，在这个过程中所产生的一系列事件，这个事件的序列以down开始，中间含有数量不定的move事件，最终以up事件结束。
     *
     * （2）. 正常情况下，一个事件序列只能被一个View拦截且消耗。这一条的原因可以参考3，因为一旦一个元素拦截了某个事件，那么同一个事件序列的所有事件都会直接交给它处理，因此同一个事件序列中的事件不能分别由两个View同时处理，但是通过特殊手段可以做到，比如
     * 一个View将本该自己处理的事件通过onTouchEvent强行传递给其他View处理。
     *
     * （3）. 某个View一旦决定拦截，那么这个事件序列都只能由它来处理（如果事件序列能够传递给它的话），并且它的onInterceptTouchEvent不会被调用。这条也很好理解，就是说当一个View决定拦截一个事件后，那么系统会把同一个事件序列内的其他方法都直接交给它来处理，因此就不用再调用这个View的onInterceptTouchEvent去询问它是否拦截了。
     *
     * （4）. 某个View一旦开始处理事件，如果它不消耗ACTION_DOWN事件（onTouchEvent返回了false），那么同一件序列中的其他事件都不会再交给它处理，并且事件 将重新交由它的父元素去处理，即父元素的onTouchEvent会被调用。意思就是事件一旦交给一个View处理，那么它就必须消耗掉，否则同一事件序列中剩下的事件就不再交给它处理了，这就好比上级交给程序员一件事，如果这件事没有处理好，短时间内上级就不敢再把事件交给这个程序员做了，二者是类似的道理。
     *
     * （5）. 如果View不消耗ACTION_DOWN以外的事件，那么这个点击事件会消失，此时父元素的onTouchEvent并不会调用，并且当前View可以持续收到后续的事件，最终这些消失的点击事件会传递给Activity处理。
     *
     * （6）. ViewGroup默认不拦截任何事件。Android源码中ViewGroup的onInterceptTouchEvent方法默认返回false。
     *
     * （7）. View没有onInterceptTouchEvent方法，一旦点击事件传递给它，那么它的onTouchEvent方法就会被调用。
     *
     * （8）. View的onTouchEvent默认都会消耗事件（返回true）,除非它是不可点击的（clickable和longClickable同时为false）。View的longClickable属性默认为false，clickable属性要分情况，比如Button的clickable属性默认为true,而TextView的clickable属性默认为false。
     *
     * （9）. View的enable属性不影响onTouchEvent的默认返回值。哪怕一个View是disable状态的，只要它的clickable或者longClickable有一个为true,那么它的onTouchEvent就返回true。
     *
     * （10）. onClick会发生的前提是当前View是可点击的，并且它接收到了down和up事件。
     *
     * （11）. 事件传递过程是由外向内的，即事件总是先传递给父元素，然后再由父元素分发给子View,通过requestDisallowInterTouchEvent方法可以在子元素中干预父元素的事件分发过程，但是ACTION_DOWN事件除外。

     */


    /**
     * 三个重要角色
     * 1、Activity：接收Down点击事件，传递给Phonewindow和DecorView
     * 2、ViewGroup：拦截事件，或者继续传递给子View
     * 3、View：决定消费这个事件或者不消费从而返回给上一级
     * 三个核心事件
     * 1、dispatchTouchEvent()：分发点击事件，return false 事件停止往子View传递和分发
     * 2、onTouchEvent() ： return false 是不消费事件，并让事件往父控件的方向从下往上流动。return true 是消费事件。
     * 3、onInterceptTouchEvent()：拦截点击事件， return false 不拦截，允许事件向子View传递， return true拦截事件，不在向子View传递事件。
     *
     */
}
