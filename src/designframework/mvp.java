package designframework;

public class mvp {
    /**
     * 针对mvc activity耦合严重的情况
     * 采用mvp架构
     * view:xml布局，activity
     * presenter:负责大量的逻辑操作
     * model:操作数据
     *
     * 与mvc的区别
     * 1.（最主要区别）View与Model并不直接交互，而是通过与Presenter交互来与Model间接交互。而在MVC中View可以与Model直接交互
     * 2. 通常View与Presenter是一对一的，但复杂的View可能绑定多个Presenter来处理逻辑。而Controller是基于行为的，并且可以被多个View共享，Controller可以负责决定显示哪个View
     * 3. Presenter与View的交互是通过接口来进行的，更有利于添加单元测试。
     *
     * 通过对比同一实例的MVC与MVP的代码，可以证实MVP模式的一些优点：
     在MVP中，Activity的代码不臃肿；
     在MVP中，Model(IUserModel的实现类)的改动不会影响Activity(View)，两者也互不干涉，而在MVC中会；
     在MVP中，IUserView这个接口可以实现方便地对Presenter的测试；
     在MVP中，UserPresenter可以用于多个视图，但是在MVC中的Activity就不行。
     *
     * 问题：
     * 1. presenter代码量过大：对于这点，有一个方法是在UI层和Presenter之间设置中介者Mediator，
     * 将例如数据校验、组装在内的轻量级逻辑操作放在Mediator中；在Presenter和Model之间使用代理Proxy
     * 2. Presenter 对 Activity 与 Fragment 的生命周期是无感知的，所以我们需要手动添加相应的生命周期方法，
     * 并进行特殊处理，以避免出现异常或内存泄露。在引入livedata后可以解决这个问题。
     */
}
