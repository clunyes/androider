package design_pattern.structural_design_pattern.proxy.base;

public class Persuit implements SendGift {
    private Girl girl;

    public Persuit(Girl girl) {
        this.girl = girl;
    }

    @Override
    public void sendFlower() {
        System.out.println("送花给" + girl.getName());
    }

    @Override
    public void sendCake() {

        System.out.println("送蛋糕给" + girl.getName());
    }

    @Override
    public void goShopping() {
        System.out.println("走！" + girl.getName());
    }
}
