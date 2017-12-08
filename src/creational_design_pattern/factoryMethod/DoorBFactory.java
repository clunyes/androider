package creational_design_pattern.factoryMethod;

public class DoorBFactory implements DoorFactory {
    @Override
    public Door factory() {
        return new DoorB();
    }
}
