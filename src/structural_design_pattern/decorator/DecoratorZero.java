package structural_design_pattern.decorator;

public class DecoratorZero extends Decorator {

    public DecoratorZero(Human human) {
        super(human);
    }

    public void goHome() {
        System.out.println("进房子");
    }

    public void findMap() {
        System.out.println("找地图");
    }

    public void wearClothes() {
        super.wearClothes();
        goHome();
    }

    public void walkToWhere() {
        super.walkToWhere();
        findMap();
    }
}
