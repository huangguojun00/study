package designmodde.strategymodel;

/**
 * @Author Huang Guojun
 * @Date 2019/8/1
 * @Discription
 */
public class Test {
    public static void main(String[] args) {
        MemberStrategy strategy = new AdvancedMemberStrategy();
        Price price = new Price(strategy);
        double quote = price.quote(500);
        System.out.println(quote);
    }
}
