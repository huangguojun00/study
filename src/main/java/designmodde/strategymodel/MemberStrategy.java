package designmodde.strategymodel;

/**
 * @Author Huang Guojun
 * @Date 2019/8/1
 * @Discription 抽象策略
 */
public interface MemberStrategy {
    /**
     * 策略方法  计算费用类型
     */
    public double calcPrice(double booksPrice);
}
