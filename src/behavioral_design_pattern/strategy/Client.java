package behavioral_design_pattern.strategy;

public class Client {

    public static void main(String[] args) {
        MemberStrategy strategy = new AdvanceMemberStrategy();
        Price price = new Price(strategy);
        double originPrice = 300;
        double quote = price.calcPrice(originPrice);
        System.out.println("图书原始价格：" + originPrice + " 图书最终价格：" + quote);
    }
}
