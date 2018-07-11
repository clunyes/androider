package design_pattern.behavioral_design_pattern.strategy;

public class AdvanceMemberStrategy implements MemberStrategy {

    @Override
    public double calcPrice(double booksPrice) {
        System.out.println("高级会员8折优惠");
        return 0.8 * booksPrice;
    }
}
