package structural_design_pattern.proxy;

public class Client {
    public static void main(String[] args) {
        JavaCoder coder = new JavaCoder("我的鹤哥");
        ProductManager pm = new ProductManager(coder);
        pm.implDemand("做一个火箭");
    }
}
