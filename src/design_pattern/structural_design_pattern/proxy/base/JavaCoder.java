package design_pattern.structural_design_pattern.proxy.base;

import design_pattern.structural_design_pattern.proxy.base.ICoder;

public class JavaCoder implements ICoder {

    private String name;
    public JavaCoder(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void implDemand(String demand) {
        System.out.println(name + "用java实现了" + demand);
    }
}
