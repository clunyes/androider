package behavioral_design_pattern.strategy;

public class Price {
    private MemberStrategy strategy;

    public Price(MemberStrategy strategy) {
        this.strategy = strategy;
    }

    public double calcPrice(double price) {
        return strategy.calcPrice(price);
    }

}
