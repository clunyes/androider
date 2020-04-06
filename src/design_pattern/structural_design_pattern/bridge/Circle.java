package design_pattern.structural_design_pattern.bridge;


public class Circle extends Shape {
    private int x;
    private int y;
    private int radius;

    public Circle(Draw draw, int x, int y, int radius) {
        super(draw);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    void draw() {
        draw.drawCircle(radius, x, y);
    }
}
