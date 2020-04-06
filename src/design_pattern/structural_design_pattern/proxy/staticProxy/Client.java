package design_pattern.structural_design_pattern.proxy.staticProxy;

import design_pattern.structural_design_pattern.proxy.base.Girl;

public class Client {
    public static void main(String[] args) {
        Girl girl = new Girl("美女");
        Proxy proxy = new Proxy(girl);
        proxy.sendFlower();
        proxy.sendCake();
    }
}
