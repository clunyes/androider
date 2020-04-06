package design_pattern.structural_design_pattern.flyweight;

public class ConcreteFlyweight implements Flyweight {
    private String string;

    public ConcreteFlyweight(String str) {
        this.string = str;
    }

    @Override
    public void operation(String str) {
        System.out.println("内部变量：" + string);
        System.out.println("外部变量：" + str);
    }
}
