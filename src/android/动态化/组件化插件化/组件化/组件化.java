package android.动态化.组件化插件化.组件化;

public class 组件化 {
    /**
     * 将一个app的代码拆分成几份独立的组件，组件之间是低耦合的，可以独立编译打包；也可以将组件打包到一个apk中。
     *
     * 【没有组件化的缺点】：
     *
     *     （1）项目可维护性下降。随着项目的增加，即使有做分包目录，但是项目会逐渐失去层次感，可读性、可维护性下降
     *     （2）开发和调试效率低。开发和调试时，修改了一个小功能，但是需要重新build整个项目才能看到结果，耗费时间
     *     （3）易阻断不同业务模块的并发开发。一个业务模块的小bug，可能阻断其他业务模块的开发和调试，不同业务模块的并发开发会被阻断。
     *     （4）版本管理困难。多人联合开发时，在版本管理中容易出现冲突和代码覆盖问题。
     *
     * 【组件化的拆分】
     *
     *     按照业务（功能）划分各个业务组件模块。
     *
     * 【组件化后的优点】
     *
     *     （1）每个模块可独立编译，提高了编译速度；
     *     （2）开发只负责自己的模块，还可以再做的隔离一些，每个业务线只可见自己业务模块的代码，避免了误修改和版本管理问题。
     *     （3）公共的Lib依然是个独立模块
     *
     * 与模块化的区别：是每个模块的角色的转换，一个组件可以独立编译打包，也可以作为lib集成到整个apk中
     *
     */
}
