package design_pattern.structural_design_pattern.bridge;

public abstract class Shape {
    public Draw draw;

    public Shape(Draw draw) {
        this.draw = draw;
    }

    abstract void draw();
}
