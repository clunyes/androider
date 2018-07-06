package behavioral_design_pattern.ChainOfResponsibility;
/**
 * 责任链模式 使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。
 * 将这些对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理它为止。
 * filterchain
 */

/**
 * okhttp的intercepter拦截器，用的就是责任链模式，巧妙的把业务和请求响应结合起来
 */
