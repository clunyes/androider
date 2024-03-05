package designframework;

public class mvvm {
    /**
     *view:xml布局，activity
     *model:操作数据
     *viewModel:（双向绑定）界面逻辑和模型数据封装，绑定的属性定义等
     *
     * 优点：
     * 数据驱动
     ViewModel只关心数据和业务逻辑，基本不需要做UI操作，是需要修改数据，databinding就能自动同步更新UI。UI的修改，又会自动同步到数据中。
     低耦合
     ViewModel不涉及任何UI操作和对UI控件的引用，就算你把TextView改成EditText，ViewModel几乎不需要改任何代码。
     团队协作
     View和ViewModel松散耦合，一个人做UI（XML + Activity），另外一个人做ViewModel 。
     单元测试
     比MVP更进一步，View和ViewModel的单元测试都很方便。
     *
     * android双向绑定
     *
     * 引入livedata后，刷新数据时不必关心view的生命周期
     */
}
