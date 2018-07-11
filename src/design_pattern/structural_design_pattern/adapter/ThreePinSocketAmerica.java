package design_pattern.structural_design_pattern.adapter;

public class ThreePinSocketAmerica implements ThreePinSocket {
    @Override
    public void chargeWithThreePin() {
        System.out.println("这是标准美式三孔插座");
    }

    @Override
    public int voltage() {
        //电压
        return 110;
    }
}
