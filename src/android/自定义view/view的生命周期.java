package android.自定义view;

public class view的生命周期 {
    /**
     * 一些其他的方法
     *
     * onFinishInflate()
     * 该方法当View及其子View从XML文件中加载完成后触发调用。通常是在Activity中onCreate方法调用后调用。
     * onVisibilityChanged()
     * 该方法在当前View或其祖先的可见性改变时被调用。如果View状态不可见或者GONE，该方法会第一个被调用。
     * onAttachedToWindow()
     * 当View被附着到一个窗口时触发。在Activity第一次执行完onResume方法后被调用。
     * onSizeChanged()
     * 该方法在Measure方法之后且测量大小与之前不一样的时候被调用。
     */
}
