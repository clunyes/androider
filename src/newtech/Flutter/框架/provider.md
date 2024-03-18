Flutter 官方的状态管理框架 Provider 则相对简单得多，不仅容易理解，而且框架的入侵性小，
还可以方便地组合和控制 UI 刷新粒度。
因此，在 Google I/O 2019 大会一经面世，Provider 就成为了官方推荐的状态管理方式之一。


Provider 是一个用来提供数据的框架。它是 InheritedWidget 的语法糖，提供了依赖注入的功能，
允许在 Widget 树中更加灵活地处理和传递数据。