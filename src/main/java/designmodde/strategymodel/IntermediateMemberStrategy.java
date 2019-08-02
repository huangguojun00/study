package designmodde.strategymodel;

/**
 * @Author Huang Guojun
 * @Date 2019/8/1
 * @Discription
 */
public class IntermediateMemberStrategy implements MemberStrategy {

    @Override
    public double calcPrice(double booksPrice) {
        System.out.println("对于中级会员的折扣为10%");
        return booksPrice * 0.9;
    }
}
