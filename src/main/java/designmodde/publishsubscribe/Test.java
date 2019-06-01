package designmodde.publishsubscribe;

/**
 * @Author Huang Guojun
 * @Date 2019/5/25
 * @Discription
 */
public class Test {
    public static void main(String[] args) {
        Subject subscriptionSubject = new SubscriptionSubject();
        // 创建微信用户
        WeixinUser huangguojun = new WeixinUser("黄国君");
        WeixinUser lishengzhong = new WeixinUser("李胜忠");
        WeixinUser buzhidao = new WeixinUser("buzhidao");
        subscriptionSubject.attach(huangguojun);
        subscriptionSubject.attach(lishengzhong);
        subscriptionSubject.attach(buzhidao);
        subscriptionSubject.notify("今天下雨了");
    }
}
