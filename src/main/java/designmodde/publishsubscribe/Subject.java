package designmodde.publishsubscribe;

/**
 * @Author Huang Guojun
 * @Date 2019/5/25
 * @Discription  抽象被观察者
 */
public interface Subject {
    /**
     * add subscribe
     * @param observer
     */
    public void attach(Observer observer);

    /**
     * delete subscribe
     * @param observer
     */
    public void detach(Observer observer);

    /**
     * notify subscribe
     * @param message
     */
    public void notify(String message);
}
