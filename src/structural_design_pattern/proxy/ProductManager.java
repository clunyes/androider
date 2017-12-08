package structural_design_pattern.proxy;

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
