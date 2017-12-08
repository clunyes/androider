package behavioral_design_pattern.visitor;

public class Client {
    public static void main(String[] args) {
        FirstTimeVisitor visitor = new FirstTimeVisitor();
        City city = new City();
        city.accept(visitor);
    }
}
