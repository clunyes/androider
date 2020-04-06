package design_pattern.creational_design_pattern.abstractFactory;

public class HangzhouFactory implements Factory {
    @Override
    public Plane getPlane() {
        return new Boyin757();
    }

    @Override
    public Train getTrain() {
        return new Gaotie();
    }
}
