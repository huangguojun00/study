package designmodde.dynamicproxy;

import java.util.Random;

/**
 * @Author Huang Guojun
 * @Date 2019/7/8
 * @Discription
 */
public class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Bird id flying");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
