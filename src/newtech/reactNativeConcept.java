package newtech;

public class reactNativeConcept {
/**
 *层次架构：
 * java层：java层为逻辑入口，启动C++层的javascript解析器，执行js通过c++传递来的渲染指令，从而构建NativeUI等。
 * java层依赖于众多优秀开源库，在图片处理使用的是Fresco，网络通信使用的是okhttp，当然还有众多工具类，如Json解析工具jackson，
 * Animation知名开源库NineOldAndroids，小而全的底层工具类bolts等，在java层均封装为Module。
 * java层核心jar包是react-native.jar，封装了众多上层的interface，如Module，Registry，bridge等，下面会以App的启用过程，完整分析java层的架构。
 *
 * c++层：c++层最主要是封装了JavaScriptCore，执行对js的解析。
 * 基于JavaScriptCore，Web开发者可以尽情使用ES6的新特性，如class、箭头操作符等，而且 React Native运行在JavaScriptCore中的，
 * 完全不存在浏览器兼容的情况。Bridge桥接了java <> js 通信的核心接口。JSLoader主要是将来自assets目录的或本地file加载到javascriptCore，
 * 再通过JSCExectutor解析js文件。
 *
 * js层：主要处理事件分发及UI Layout
 *
 * js主要有以下部件：
 * component：Js层通js/jsx编写的Virtual Dom来构建Component或Module，Virtual DOM是DOM在内存中的一种轻量级表达方式，
 * 可以通过不同的渲染引擎生成不同平台下的UI。component的使用在 React 里极为重要, 因为component的存在让计算 DOM diff 更高效。
 *
 * lifecycle&data：React 组件通过内部的 state 变量控制生命周期及事件回调。如getInitialState方法用于定义组件初始状态，
 * 后续组件可通过 this.state 属性读取该状态。当事件触发（或者主动调用setState方法更新数据）导致状态变化，this.setState 方法就修改状态值，
 * 每次修改以后，自动调用 this.render 方法，重新渲染组件。
 *
 * layout：
 *
 * js与java通信：
 * 在Java层与Js层的bridge分别存有相同一份模块配置表，Java与Js互相通信时，
 * 通过bridge里的配置表将所调用模块方法转为{moduleID,methodID,args}的形式传递给处理层，
 * 处理层通过bridge的模块配置表找到对应的方法执行，如果有callback，则回传给调用层。
 *
 * java主动调用js，js事件post到messageQueue，等待java事件触发
 */
}
