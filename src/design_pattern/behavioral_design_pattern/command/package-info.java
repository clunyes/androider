package design_pattern.behavioral_design_pattern.command;
/**
 * 在软件设计中，我们经常需要向某些对象发送请求，但是并不知道请求的接收者是谁，也不知道被请求的操作是哪个，
 * 我们只需在程序运行时指定具体的请求接收者即可，此时，可以使用命令模式来进行设计，使得请求发送者与请求接收者消除彼此之间的耦合，让对象之间的调用关系更加灵活。
 *
 * 将操作作为对象，分离请求者和执行者。
 */

/**
 * android中常见的handler就是command模式，message及内部的looper和handler
 *
 接受者：Handler，执行消息的处理操作。
 调用者：Looper，调用消息的的处理方法。
 命令角色：Message，消息类。

 */
