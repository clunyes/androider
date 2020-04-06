package design_pattern.creational_design_pattern.simpleFactory;

public class FoodFactory {

    public static Food getFood(String type) {
        if (type.equals("mcchicken")) {
            return new McChicken();
        } else if (type.equals("chips")) {
            return new Chips();
        }else{
            System.out.println("我们暂时不卖这玩意");
            return null;
        }
    }
}
