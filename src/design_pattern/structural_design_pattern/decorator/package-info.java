package design_pattern.structural_design_pattern.decorator;
/**
 * 动态给一个对象添加一些额外的职责,就象在墙上刷油漆.
 * 使用Decorator模式相比用生成子类方式达到功能的扩充显得更为灵活。
 */
/**
 * Context类在这里就充当了抽象组件的角色，ContextImpl类则是具体的组件，
 * 而ContextWrapper就是具体的装饰角色，通过扩展ContextWrapper增加不同的功能，就形成了Activity、Service等子类。
 */
