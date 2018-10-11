package language.kotlin;

public class ktlazy {
    /**
     *lateinit 和 lazy 是 Kotlin 中的两种不同的延迟初始化的实现
     lateinit 只用于变量 var，而 lazy 只用于常量 val

     lazy 应用于单例模式(if-null-then-init-else-return)，而且当且仅当变量被第一次调用的时候，委托方法才会执行。
     val lazyValue: String by lazy {
     println("computed!")
     "Hello"
     }

     fun main(args: Array<String>) {
     println(lazyValue)
     println(lazyValue)
     }

     打印结果
     computed！
     Hello

     Hello

     比如这样的常见操作，只获取，不赋值，并且多次使用的对象(UserConfig)
     */
}
