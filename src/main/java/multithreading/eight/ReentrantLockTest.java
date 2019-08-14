package multithreading.eight;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Huang Guojun
 * @Date 2019/8/14
 * @Discription
 */
public class ReentrantLockTest {
    public static void main(String[] args) {
        Myservice service = new Myservice();

        MyThread a1 = new MyThread(service);
        MyThread a2 = new MyThread(service);
        MyThread a3 = new MyThread(service);
        MyThread a4 = new MyThread(service);
        MyThread a5 = new MyThread(service);

        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();
    }

    static public class Myservice{
        private Lock lock = new ReentrantLock();
        public void testMethod(){
            lock.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("ThreadName=" + Thread.currentThread().getName() + (" " + (i + 1)));
                }
            } finally {
                lock.unlock();
            }
        }
    }


    static class  MyThread extends Thread{
        private Myservice myservice;

        public MyThread(Myservice myservice) {
            super();
            this.myservice = myservice;
        }

        @Override
        public void run() {
            myservice.testMethod();
        }
    }


}
