package android.生命周期;

public class android横竖屏生命周期 {
    /**
     * manifest中加入android:configChanges="keyboardHidden|orientation|screenSize"可以避免重走生命周期，
     * 不然横竖屏就是把之前的页面销毁掉，而后重新创建了页面
     *
     * 横竖屏切换只会调用onConfigurationChanged
     */
}
