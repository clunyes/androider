package structural_design_pattern.facde;

public class Client {
    public static void main(String[] args) {
        MyFacade facade = new MyFacade();
        facade.turnOn();
        facade.turnOff();
    }
}
