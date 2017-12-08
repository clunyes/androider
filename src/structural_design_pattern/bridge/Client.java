package structural_design_pattern.bridge;

public class Client {
    public static void main(String[] args) {
        Shape redCircle = new Circle(new DrawGreenCircle(), 100, 1, 1);
        Shape greenCircle = new Circle(new DrawRedCircle(), 500, 50, 50);

        redCircle.draw();
        greenCircle.draw();
    }
}
