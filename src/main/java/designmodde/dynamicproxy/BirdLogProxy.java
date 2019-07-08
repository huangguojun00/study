package designmodde.dynamicproxy;

/**
 * @Author Huang Guojun
 * @Date 2019/7/8
 * @Discription
 */
public class BirdLogProxy implements Flyable {

    private Flyable flyable;

    public BirdLogProxy(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        System.out.println("Bird fly start...");

        flyable.fly();

        System.out.println("Bird fly end...");
    }
}
