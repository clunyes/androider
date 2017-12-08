package creational_design_pattern.abstractFactory;

public class Client {

    public static void main(String[] args) {
        ChanganFactory changanFactory = new ChanganFactory();
        Plane changanPlane = changanFactory.getPlane();
        Train changanTrain = changanFactory.getTrain();
        changanPlane.fly();
        changanTrain.run();

        HangzhouFactory hangzhouFactory = new HangzhouFactory();
        Plane hangzhouPlane = hangzhouFactory.getPlane();
        Train hangzhouTrain = hangzhouFactory.getTrain();
        hangzhouPlane.fly();
        hangzhouTrain.run();
    }
}
