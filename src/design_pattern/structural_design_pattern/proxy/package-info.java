package design_pattern.structural_design_pattern.proxy;
//提供了对目标对象另外的访问方式;即通过代理对象访问目标对象.这样做的好处是:可以在目标对象实现的基础上,增强额外的功能操作,即扩展目标对象的功能.


//不要随意去修改别人已经写好的代码或者方法,如果需改修改,可以通过代理的方式来扩展该方法

/**
 * 三种代理
 * <p>
 * 静态代理：即为demo中代码所用
 * <p>
 * 动态代理：静态代理，会造成代理类多。动态代理可以实现aop编程
 * <p>
 * ActivityManagerProxy
 */
/**
 *
 * 代理模式（Proxy 模式）可理解为：我想做，但不能做，我需要有一个能干的人来帮我做。
 *
 * 装饰器模式（Decorator 模式）可理解为：我想做，但不能做，我需要有各类特长的人来帮我做，但我有时只需要一个人，有时又需要很多人。
 *
 * 它们的区别就是，Proxy 模式需要的是一个能人，而 Decorator 模式需要的是一个团队。
 *
 */
