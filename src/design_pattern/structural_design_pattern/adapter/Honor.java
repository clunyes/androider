package design_pattern.structural_design_pattern.adapter;

public class Honor {

    private TwoPinSocket twoPinSocket;

    public Honor() {
    }

    public void setTwoPinSoket(TwoPinSocket twoPinSoket) {
        this.twoPinSocket = twoPinSoket;
    }

    public void chargeRequest() {
        System.out.println("华为荣耀手机， " + twoPinSocket.voltage() + " 伏特充电中\n");
    }
}
