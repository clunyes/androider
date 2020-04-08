package android.事件;

public class event坐标 {
    /**
     * 1 控件的top
     * 2 控件的left
     * 3 控件的bottom
     * 4 控件的right
     * 5 控件移动的translationX（上面图画错了，translationX，translationY的参照点默认为控件中心点）
     * 6 控件移动的translationY
     * 7 控件的y，即view的getY()
     * 8 控件的x，即view的getX()
     * 9 点击事件的y，即MotionEvent的getY()
     * 10 点击事件的x，即MotionEvent的getX()
     * 11 点击事件的rawY，即MotionEvent的getRawY()
     * 12 点击事件的rawX，即MotionEvent的getRawX()
     */
    /**
     * left/top，right/bottom 的值都是相对父容器而言的，具体为父容器的左上角，
     * 而 translationX/Y 可以移动这个参照点（父容器左上角），通过改变参照点的位置来改变 View 的位置。
     *
     * 这里要注意的是 translationX/Y 改变参照点的位置是理论上的改变，
     * 只是子 View 参照的位置变了，父容器左上角的实际坐标是没有变化的。
     *
     * 在这种情况下（translationX/Y 均不为 0，即子 View 的参照点位置变了），x/y 和 left/top 的值就不相等了，
     * 此时 x/y 的值是参照父容器左上角实际位置的坐标，而 left/top 是参照 translationX/Y 变化后的坐标点的值。
     *
     */
}
