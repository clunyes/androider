package design_pattern.structural_design_pattern.proxy.staticProxy;

public class AdminServiceImpl implements AdminService{

    public void update() {
        System.out.println("修改管理系统数据");
    }

    public Object find() {
        System.out.println("查看管理系统数据");
        return new Object();
    }
}
