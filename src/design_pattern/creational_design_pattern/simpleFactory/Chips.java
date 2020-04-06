package design_pattern.creational_design_pattern.simpleFactory;

public class Chips implements Food {

    public Chips() {

    }

    @Override
    public void get() {
        System.out.println("来一份薯条");
    }
}
