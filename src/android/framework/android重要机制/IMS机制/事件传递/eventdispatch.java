package android.framework.android重要机制.IMS机制.事件传递;

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
     * 1.Touch事件分发中只有两个主角:ViewGroup和View。ViewGroup包含onInterceptTouchEvent、
     * dispatchTouchEvent、onTouchEvent三个相关事件。
     * View包含dispatchTouchEvent、onTouchEvent两个相关事件。其中ViewGroup又继承于View。
     *
     * 2.ViewGroup和View组成了一个树状结构，根节点为Activity内部包含的一个ViwGroup。
     *
     * 3.触摸事件由Action_Down、Action_Move、Action_UP组成，其中一次完整的触摸事件中，Down和Up都只有一个，Move有若干个，可以为0个。
     */


    /**
     * 三个重要角色
     * 1、Activity：接收Down点击事件，传递给Phonewindow和DecorView
     * 2、ViewGroup：拦截事件，或者继续传递给子View
     * 3、View：决定消费这个事件或者不消费从而返回给上一级
     *
     * 三个核心事件
     * 1、dispatchTouchEvent()：分发点击事件，返回false则不拦截继续往下分发;返回true则拦截住该事件不在向下层元素分发;
     * 2、onTouchEvent()： return false是不消费事件，并让事件往父控件的方向从下往上流动。return true 是消费事件。
     * 3、onInterceptTouchEvent()：拦截点击事件， return false 不拦截，允许事件向子View传递，
     * return true拦截事件，不在向子View传递事件。
     */
}
