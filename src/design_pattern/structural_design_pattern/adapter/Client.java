package design_pattern.structural_design_pattern.adapter;

public class Client {

    public static void main(String[] args) {
        // 在中国，用两孔插座充电
        TwoPinSocketChina twoPinSocketChina = new TwoPinSocketChina();
        Honor mHonor = new Honor();
        mHonor.setTwoPinSoket(twoPinSocketChina);
        mHonor.chargeRequest();

        // 然后坐飞机去美国旅游，美国某旅馆的墙上有只有一个三孔插座
        ThreePinSocketAmerica threePinSocketAmerica = new ThreePinSocketAmerica();
        testThreePin(threePinSocketAmerica);

        // 幸好我有美国适配器，一头插到三孔插座，另一头转换成二孔插座，就可以给我的荣耀手机充电
        AmericaAdapter americaAdapter = new AmericaAdapter(threePinSocketAmerica);
        testTwoPin(americaAdapter);

        // 在美国，通过美国适配器，用三空插座充电
        mHonor.setTwoPinSoket(americaAdapter);
        mHonor.chargeRequest();
    }

    static void testTwoPin(TwoPinSocket twoPinSocket) {
        twoPinSocket.chargeWithTwoPin();
        System.out.println("电压是" + twoPinSocket.voltage() + "伏特\n");
    }

    static void testThreePin(ThreePinSocket threePinSocket) {
        threePinSocket.chargeWithThreePin();
        System.out.println("电压是" + threePinSocket.voltage() + "伏特\n");
    }
}
