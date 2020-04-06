package design_pattern.behavioral_design_pattern.strategy;

public class IntermediateMemberStrategy implements MemberStrategy {

    @Override
    public double calcPrice(double booksPrice) {
        System.out.println("中级会员9折优惠");
        return 0.9 * booksPrice;
    }
}
