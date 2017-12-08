package creational_design_pattern.factoryMethod;

public class Client {
    public static void main(String[] args) {
        DoorAFactory factoryA = new DoorAFactory();
        DoorBFactory factoryB = new DoorBFactory();

        factoryA.factory();
        factoryB.factory();
    }
}
