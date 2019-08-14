package multithreading.three;

/**
 * @Author Huang Guojun
 * @Date 2019/8/13
 * @Discription
 */
public class MyThread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            System.out.println("i="+(i+1));
        }
    }
}
