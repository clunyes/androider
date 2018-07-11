package design_pattern.structural_design_pattern.proxy.staticProxy;

import design_pattern.structural_design_pattern.proxy.base.ICoder;

//产品经理，码农的代理
public class ProductManager implements ICoder {
    private ICoder iCoder;

    public ProductManager(ICoder coder) {
        iCoder = coder;
    }

    @Override
    public void implDemand(String demand) {
        iCoder.implDemand(demand);
    }
}
