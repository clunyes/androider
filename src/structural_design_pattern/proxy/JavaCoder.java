package structural_design_pattern.proxy;

public class JavaCoder implements ICoder {

    private String name;

    public JavaCoder(String name) {
        this.name = name;
    }

    @Override
    public void implDemand(String demand) {
        System.out.println(name + "用java实现了" + demand);
    }
}
