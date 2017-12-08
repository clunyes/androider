package structural_design_pattern.adapter;

public class TwoPinSocketChina implements TwoPinSocket{
    @Override
    public void chargeWithTwoPin() {
        System.out.println("这是标准中国两孔插座");
    }

    @Override
    public int voltage() {
        return 220;
    }
}
