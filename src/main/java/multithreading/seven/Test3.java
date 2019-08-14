package multithreading.seven;

import java.util.Date;

/**
 * @Author Huang Guojun
 * @Date 2019/8/14
 * @Discription
 */
public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("   在main线程中的取值="+Tools.threadLocalExt.get());
            Thread.sleep(100);
        }
        Thread.sleep(5000);
        ThradA a = new ThradA();
        a.start();
    }


    static class Tools{
        public static ThreadLocalExt threadLocalExt = new ThreadLocalExt();
    }

    static class ThreadLocalExt extends ThreadLocal{
        @Override
        protected Object initialValue() {
            return System.currentTimeMillis();
        }
    }

    static class ThradA extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("在ThreadA线程中取值"+Tools.threadLocalExt.get());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
