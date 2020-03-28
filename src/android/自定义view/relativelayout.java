package android.自定义view;

public class relativelayout {
    /**
     * 结论：relativelayout比linearlayout效率低
     *
     * 1.RelativeLayout会让子View调用2次onMeasure，LinearLayout 在有weight时，也会调用子View2次onMeasure
     * 2.RelativeLayout的子View如果高度和RelativeLayout不同，则会引发效率问题，当子View很复杂时，这个问题会更加严重。
     * 如果可以，尽量使用padding代替margin。
     * 3.在不影响层级深度的情况下,使用LinearLayout和FrameLayout而不是RelativeLayout。
     *
     * linearlayout使用layout_weight属性后，也会measure两次
     *
     */
}
