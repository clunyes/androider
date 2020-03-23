package design_pattern.structural_design_pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimingInvocationHandler implements InvocationHandler {
    private Object target;
    //    private Persuit target;这里的成员变量类型可以换成object类型

    public TimingInvocationHandler(Object target) {
        super();
        this.target = target;
    }
    public TimingInvocationHandler() {
        super();
    }

    /**
     *
     * @param proxy 通过Proxy.newProxyInstance()生成的代理类对象
     * @param method 表示代理对象被调用的函数
     * @param args 表示代理类对象被调用的函数的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始送礼物");
        //target 属性表示真实委托类对象。
        Object obj = method.invoke(target, args);

        System.out.println("送礼物完成");

        return obj;
    }
}
