package behavioral_design_pattern.state;

public class Client {
    public static void main(String[] args) {
        AuxLift lift = new AuxLift();
        lift.open();
        lift.close();
        lift.run();
        lift.stop();
        lift.open();
    }
}
