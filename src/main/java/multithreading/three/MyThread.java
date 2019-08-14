package multithreading.three;

/**
 * @Author Huang Guojun
 * @Date 2019/8/13
 * @Discription
 */
public class MyThread implements Runnable{

    private int count = 100;

    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName()+"-----count"+count);
    }
}
