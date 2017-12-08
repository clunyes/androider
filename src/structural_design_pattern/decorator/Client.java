package structural_design_pattern.decorator;

public class Client {

    public static void main(String[] args) {
        Human person = new Person();
        Decorator decorator = new DecoratorTwo(new DecoratorOne(new DecoratorZero(person)));
        decorator.wearClothes();
        decorator.walkToWhere();
    }
}
