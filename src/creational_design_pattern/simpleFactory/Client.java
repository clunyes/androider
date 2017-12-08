package creational_design_pattern.simpleFactory;

public class Client {

    public static void main(String[] args) {
        Food mcChicken = FoodFactory.getFood("mcchicken");
        Food chips = FoodFactory.getFood("chips");
        Food egg = FoodFactory.getFood("egg");

        if (mcChicken != null) {
            mcChicken.get();
        }
        if (chips != null) {
            chips.get();
        }
        if (egg != null) {
            egg.get();
        }
    }


}
