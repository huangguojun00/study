package designmodde.strategymodel;

/**
 * @Author Huang Guojun
 * @Date 2019/8/1
 * @Discription
 */
public class AdvancedMemberStrategy implements MemberStrategy {
    @Override
    public double calcPrice(double booksPrice) {
        System.out.println("对于高级会员的折扣为20%");
        return booksPrice * 0.8;
    }
}
