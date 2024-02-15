### RN是什么
React Native，也被称为RN，是一个开源的UI软件框架。它是建立在React库之上的。
它是一个基于JavaScript的移动应用框架，允许我们为Android和iOS建立原生渲染的应用程序。

React Native的原理是：在JavaScript中用React抽象操作系统原生的UI组件，
代替DOM元素来渲染，比如以<View>取代<div>，以<Image>替代<img>等。

### RN的优缺点
优点
- 构建速度更快
React Native最重要的好处之一是它的开发时间短。它有多个随时可用的组件，可以加速移动应用的开发。

- 一个框架，多个平台
React Native使开发者能够在安卓和iOS平台之间共享一段代码。此外，React Native支持在React网络应用之间共享代码库。
这种平台间代码的可重用性节省了大量的时间，并降低了应用开发的整体成本。


- 更小的团队
Android和iOS的原生移动应用的开发需要两个团队。而且，单个安卓和iOS团队采用不同的应用开发方法 。
这又导致了分别为Android和iOS平台开发的移动应用的不一致性。
但是，当我们选择React Native时，我们只需要一个具有完善的JavaScript知识的团队，
可以为两个平台编写代码。因此，使用React Native可以减少团队规模。

- 热重载
React Native的热重载功能使其更加独特。这个重载功能是基于热模块替换（HMR）的。
HMR是一个协助更新文件并在应用程序工作时将其维持在特定位置的中间媒介。它使React移动应用程序能够有效地管理多个任务。
通过热重载，开发人员可以实时看到对一个应用程序所做的改变。


- 现成的解决方案和充满活力的库
React Native有一系列现成的解决方案和React库，以加强移动应用程序的开发过程。
例如，它有一个测试库，允许开发人员编写无错误和无漏洞的代码。 
除了测试，如果开发者希望观察成功的类型检查，他们可以利用ESlint、Axios等工具。

缺点
- 调试非常困难
由于React Native是使用JavaScript、Objective-C、C/C++和Java开发的，所以调试React Native移动应用是非常具有挑战性和繁琐的。
开发人员需要对开发应用程序的平台的本地语言有所了解。
为了克服调试的问题，React Native社区和开发者已经实现了React Native与Flipper的整合。
总的来说，Flipper提供了几个对调试有用的工具，如错误报告和日志预览工具，本地数据库和性能检查器。


- 没有类型安全
开发人员可以使用JavaScript来创建React Native的移动应用程序。
不可否认，JavaScript是最灵活和最广泛使用的编程语言之一。
然而，它也是一种松散的类型化语言。因此，没有类型安全，这最终使得React Native移动应用程序的扩展具有挑战性。


- 新的和不成熟的
React Native仍处于改进阶段，与其他广泛使用的开发Android和iOS应用程序的框架相比，它是一个新框架。
因此，使用React Native的开发者可能会发现该框架中缺少一些功能。
