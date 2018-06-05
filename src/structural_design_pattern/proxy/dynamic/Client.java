package structural_design_pattern.proxy.dynamic;

import structural_design_pattern.proxy.base.ICoder;
import structural_design_pattern.proxy.base.JavaCoder;
import structural_design_pattern.proxy.staticProxy.ProductManager;

public class Client {

    public static void main(String[] args) {
        // 目标对象
        ICoder target = new JavaCoder();
        ((JavaCoder)target).setName("阿鹤");
        System.out.println(target.getClass());

        ICoder pm = new ProductManager(target);
        pm.implDemand("豪哥搞的产品");
// 给目标对象，创建代理对象
        ICoder proxy = (ICoder) new ProxyFactory(target).getProxyInstance();
        // class $Proxy0   内存中动态生成的代理对象
        System.out.println(proxy.getClass());
        proxy.implDemand("动态代理了");
    }
}
