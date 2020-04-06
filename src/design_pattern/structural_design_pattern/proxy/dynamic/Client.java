package design_pattern.structural_design_pattern.proxy.dynamic;

import design_pattern.structural_design_pattern.proxy.base.Girl;
import design_pattern.structural_design_pattern.proxy.base.Persuit;
import design_pattern.structural_design_pattern.proxy.base.SendGift;

import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        Girl girl = new Girl("芳芳");
        TimingInvocationHandler timingInvocationHandler
                = new TimingInvocationHandler(new Persuit(girl));

        SendGift sendGift = (SendGift) Proxy.newProxyInstance(SendGift.class.getClassLoader(), new Class[]{SendGift.class},
                timingInvocationHandler);


        // call method of proxy instance

        sendGift.sendCake();

        sendGift.sendFlower();
        sendGift.goShopping();
    }
}
