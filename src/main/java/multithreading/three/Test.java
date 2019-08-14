package multithreading.three;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Huang Guojun
 * @Date 2019/8/13
 * @Discription
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        MyThread myThread = new MyThread();
        MyThread1 myThread1 = new MyThread1();
        pool.submit(myThread1);
        Thread.sleep(1000);
        pool.shutdown();

    }
}
