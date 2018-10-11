package language.kotlin;

public class innerIt {
    /**
     *
     * ?表示可以为空
     * 内部 it

     * 当一个 lambda 表达式只有一个参数的时候，你可以在你的代码中将其省略，并用 it 代替。

     * it：单参数的内部名称。当你表达式只有一个参数的时候，这是一个很有用的特性，声明的过程可以省略(就像 ->)，并且参数名称为 it。
     * 问题是，当你的代码中存在向下面例子一样的嵌套函数的时候：

     val list = listOf("foo.bar", "baz.qux")
     list.forEach {
     it.split(".").forEach {
     println(it)
     }
     }
     it 参数会混淆。解决方法就是像下面这样显示的声明：

     list.forEach { item ->
     item.split(".").forEach { part ->
     println(part)
     }
     }
     */

}