package creational_design_pattern.factoryMethod;

public class DoorAFactory implements DoorFactory {
    @Override
    public Door factory() {
        return new DoorA();
    }
}
