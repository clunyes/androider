package design_pattern.structural_design_pattern.flyweight;

public class Client {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        ConcreteFlyweight xcFlyweight = factory.factory("大下城区");
        ConcreteFlyweight scFlyweight = factory.factory("大下城区");
        ConcreteFlyweight xhFlyweight = factory.factory("大西湖区");
        xcFlyweight.operation("下城区上班");
        scFlyweight.operation("上城区吃饭");
        xhFlyweight.operation("西湖区玩耍");
        System.out.println(xcFlyweight == scFlyweight);
        System.out.println(factory.getFactorySize());
    }

}
