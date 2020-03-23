package design_pattern.structural_design_pattern.proxy.staticProxy;

import design_pattern.structural_design_pattern.proxy.base.Girl;
import design_pattern.structural_design_pattern.proxy.base.Persuit;
import design_pattern.structural_design_pattern.proxy.base.SendGift;

public class Proxy implements SendGift {
    private Persuit persuit;

    public Proxy(Girl girl) {
        persuit = new Persuit(girl);

    }

    @Override
    public void sendFlower() {
        persuit.sendFlower();

    }

    @Override
    public void sendCake() {

        persuit.sendCake();
    }

    @Override
    public void goShopping() {

    }
}
