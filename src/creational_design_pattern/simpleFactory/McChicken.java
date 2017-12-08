package creational_design_pattern.simpleFactory;

public class McChicken implements Food {

    public McChicken() {

    }

    @Override
    public void get() {
        System.out.println("一份McChicken");
    }
}
