package android.生命周期;

public class fragment生命周期 {
    /**
     * (1) onAttach()：与Activity进行一个绑定
     *
     * (2) onCreate()：创建Fragment时的回调
     *
     * (3) onCreateView：创建、绘制Fragment的View时回调该方法
     *
     * (4) onActivityCreated：当Fragment所在的Activity被完全创建时回调该方法
     *
     * (5) onStart()：调用该方法时Fragment可见，但不可与用户进行交互
     *
     * (6) onResume()：调用该方法时Fragment可见也可与用户交互
     *
     * (7) onPause()：Fragment失去焦点，不可与用户交互
     *
     * (8) onStop()：Fragment停止，失去焦点、不可与用户交互、不可见
     *
     * (9) onDestroyView()：销毁Fragment视图，但未与Activity解除绑定
     *
     * (10) onDestroy()：销毁Fragment时的调用
     *
     * (11) onDetach()：与Activity解除绑定
     *
     * Fragment虽然有onResume()和onPause()方法，但是这两个方法是Activity的方法调用时机也与Activity相同，和ViewPager搭配使用这个方法就很鸡肋了，根本不是你想要的效果，使用onHiddenChanged。
     */
}
