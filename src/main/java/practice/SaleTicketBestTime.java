package practice;

/**
 * @Author Huang Guojun
 * @Date 2019/6/29
 * @Discription 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 */
public class SaleTicketBestTime {
    public static int maxProfit(int[] prices) {
        int money = 0;
        for (int i = 1; i < prices.length; i++) {
            int i1 = prices[i] - prices[i - 1];
            if (i1 > 0) {
                money = money + i1;
            }
        }
        return money;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int i = maxProfit(arr);
        System.out.println(i);
    }
}
