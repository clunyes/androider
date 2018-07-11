package design_pattern.structural_design_pattern.decorator;

public class Person implements Human {
    @Override
    public void wearClothes() {
        System.out.println("穿衣服啦");
    }

    @Override
    public void walkToWhere() {
        System.out.println("去哪里呢");
    }
}
