package design_pattern.structural_design_pattern.facade;

public class Client {
    public static void main(String[] args) {
        MyFacade facade = new MyFacade();
        facade.turnOn();
        facade.turnOff();
    }
}
