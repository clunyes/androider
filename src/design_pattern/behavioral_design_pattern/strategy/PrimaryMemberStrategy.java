package design_pattern.behavioral_design_pattern.strategy;

public class PrimaryMemberStrategy implements MemberStrategy {

    @Override
    public double calcPrice(double booksPrice) {
        System.out.println("普通会员没有折扣");
        return booksPrice;
    }
}
