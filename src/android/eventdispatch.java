package android;

public class eventdispatch {
    /**
     * onInterceptTouchEvent
     * dispatchTouchEvent
     * onTouchEvent
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
     * 参考资料 https://www.jianshu.com/p/38015afcdb58
     *
     * 1.Touch事件分发中只有两个主角:ViewGroup和View。ViewGroup包含onInterceptTouchEvent、dispatchTouchEvent、onTouchEvent三个相关事件。
     * View包含dispatchTouchEvent、onTouchEvent两个相关事件。其中ViewGroup又继承于View。
     *
     * 2.ViewGroup和View组成了一个树状结构，根节点为Activity内部包含的一个ViwGroup。
     *
     * 3.触摸事件由Action_Down、Action_Move、Aciton_UP组成，其中一次完整的触摸事件中，Down和Up都只有一个，Move有若干个，可以为0个。
     *
     * 4.当Acitivty接收到Touch事件时，将遍历子View进行Down事件的分发。ViewGroup的遍历可以看成是递归的。
     * 分发的目的是为了找到真正要处理本次完整触摸事件的View，这个View会在onTouchuEvent结果返回true。
     *
     * 5.当某个子View返回true时，会中止Down事件的分发，同时在ViewGroup中记录该子View。
     * 接下去的Move和Up事件将由该子View直接进行处理。由于子View是保存在ViewGroup中的，
     * 多层ViewGroup的节点结构时，上级ViewGroup保存的会是真实处理事件的View所在的ViewGroup对象:
     * 如ViewGroup0-ViewGroup1-TextView的结构中，TextView返回了true，它将被保存在ViewGroup1中，
     * 而ViewGroup1也会返回true，被保存在ViewGroup0中。当Move和UP事件来时，会先从ViewGroup0传递至ViewGroup1，再由ViewGroup1传递至TextView。
     *
     * 6.当ViewGroup中所有子View都不捕获Down事件时，将触发ViewGroup自身的onTouch事件。
     * 触发的方式是调用super.dispatchTouchEvent函数，即父类View的dispatchTouchEvent方法。
     * 在所有子View都不处理的情况下，触发Acitivity的onTouchEvent方法。
     *
     * 7.onInterceptTouchEvent有两个作用：1.拦截Down事件的分发。2.中止Up和Move事件向目标View传递，使得目标View所在的ViewGroup捕获Up和Move事件。
     */
}
