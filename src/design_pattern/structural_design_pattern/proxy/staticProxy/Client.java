package design_pattern.structural_design_pattern.proxy.staticProxy;

import design_pattern.structural_design_pattern.proxy.base.JavaCoder;

public class Client {
    public static void main(String[] args) {
        JavaCoder coder = new JavaCoder();
        coder.setName("我的鹤哥");
        ProductManager pm = new ProductManager(coder);
        pm.implDemand("做一个火箭");
    }
}
