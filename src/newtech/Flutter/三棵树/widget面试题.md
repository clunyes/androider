#### 无状态组件（StatelessWidget）
无状态组件，可以理解为将外部传入的数据转化为界面展示的内容，只会渲染一次。

#### 有状态组件（StatefulWidget）
有状态组件，是定义交互逻辑和业务数据，可以理解为具有动态可交互的内容界面，会根据数据的变化进行多次渲染。


Flutter 生命周期的整个过程可以分为四个阶段（生命周期是一个widget组件加载到卸载的整个周期）
初始化阶段：createState 和 initState
组件创建阶段：didChangeDependencies 和 build
触发组件 build：didChangeDependencies、setState 或者didUpdateWidget 都会引发的组件重新 build
组件销毁阶段：deactivate 和 dispose
