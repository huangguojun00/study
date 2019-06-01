package designmodde.publishsubscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Huang Guojun
 * @Date 2019/5/25
 * @Discription 具体的被观察者
 */
public class SubscriptionSubject implements Subject {
    // 存储订阅微信公众号的微信用户
    private List<Observer> weixinUserList = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        weixinUserList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        weixinUserList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : weixinUserList) {
            observer.update(message);
        }
    }
}
