package creational_design_pattern.abstractFactory;

public class ChanganFactory implements Factory {
    @Override
    public Plane getPlane() {
        return new Boyin747();
    }

    @Override
    public Train getTrain() {
        return new Dongche();
    }
}
