package project.代码规范;

public class view的规范 {
    /**
     * 1. adapter viewholder缓存，复用时要判断状态，手动置成初始值
     * 2. 减少ViewGroup的无用嵌套
     * 3. 子view父view的重复背景
     * 4. 禁止scrollview包裹recyclerview，最好使用NestedScrollView。
     * 5. 不要在非 UI 线程中初始化 ViewStub，否则会返回 null。
     * 6. png 图片使用 tinypng 或者类似工具压缩处理，减少包体积。
     *
     *
     */
}
