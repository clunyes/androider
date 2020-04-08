package android.广播;

public class 显式intent {
    /**
     *     Intent intent = new Intent();
     *     intent.setClassName("com.android.deskclock","com.android.deskclock.DeskClock");
     *
     *     startActivity(intent);
     * 显式意图明确指定了要激活的组件是哪个组件，一般是在应用程序内部使用。
     */
    /**
     * //分享功能就是通过隐式Intent完成的。
     * Intent sendIntent = new Intent();
     * sendIntent.setAction(Intent.ACTION_SEND);
     * sendIntent.putExtra(Intent.EXTRA_TEXT,"This is my text to send.");
     * sendIntent.setType("text/plain");
     * startActivity(sendIntent);
     */
    /**
     * LocalBroadcastManager 应用内发广播，androidx已废弃
     */
}
