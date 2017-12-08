package structural_design_pattern.bridge;

public class DrawRedCircle implements Draw {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                + radius + ", x: " + x + ", y: " + y + "]");
    }
}
