package android.系统分层.应用层.jetpack;

public class viewmodel {
    /**
     * ViewModel 注重生命周期的方式存储和管理界面相关的数据。
     * 在配置更改期间会自动保留 ViewModel 对象，以便它们存储的数据立即可供下一个 Activity 或 Fragment 实例使用。
     *
     * 1.当我们的Activity/Fragment因为某些因素被销毁重建时，我们的成员变量便失去了意义。
     * 因此我们常常需要通过 onSaveInstanceState()和onCreate()/onSaveInstanceState(Bundle)完成对数据的恢复
     * （通常还要保证其正确的序列化）。并且对于大型数据来书，便有些乏力，比如：List、Bitmap...
     *
     * 2.另一个问题是Activity/Fragment经常需要进行一些异步操作。一旦涉及到异步，我们都明白这里存在内存泄漏的可能性。
     * 因此我们保证Activity/Fragment在销毁后及时清理异步操作，以避免潜在的内存泄漏。
     *
     *ViewModel并没有自动帮我们解决这个问题，而是通过onCleared()交给我们业务自己重写去处理。
     */
    /**
     * 如图所示，第一次ondestroy指的是意外关闭，viewmodel并未回收，finish关闭之后，正式回收
     */
    /**
     * 在海小豚的MVVM框架中，ViewModel负责数据逻辑处理
     */
}
