package sourcecode.butterknife;

public class butterknife {
    /**
     * 通过bind()方法传入一个对象与视图
     * 通过传入的绑定对象利用反射原理找到对应的viewBinding类并获取到构造函数
     * 构造函数通过反射实例化了ViewBinding类并把绑定的对象与视图传到ViewBinding类中
     * (绑定对象的ViewBinding类是怎么来的呢？)
     *
     *
     */
    /**
     * (绑定对象的ViewBinding类是怎么来的呢？)
     * 在注解了某些代码元素（如字段、函数、类等）后，在编译时编译器会检查 AbstractProcessor 的子类，
     * 并且自动调用其 process() 方法，然后将添加了指定注解的所有代码元素作为参数传递给该方法，
     * 开发者再根据注解元素获取相应的对象信息。根据这些信息通过 javapoet 生成我们所需要的代码。
     *
     * 通过注解生成的
     */
}
