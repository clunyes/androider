package structural_design_pattern.adapter;
// 去美国旅游，必须带上一个“美国适配器”：实现两孔插座，组合三孔插座。用来给我的荣耀手机充电
public class AmericaAdapter implements TwoPinSocket {

    private ThreePinSocket threePinSocket;

    public AmericaAdapter(ThreePinSocket socket) {
        threePinSocket = socket;
    }

    @Override
    public void chargeWithTwoPin() {
        threePinSocket.chargeWithThreePin();
    }

    @Override
    public int voltage() {
        // 适配器把电压从 110V 升到 220V
        return 110 * 2;
    }
}
