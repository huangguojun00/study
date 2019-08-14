package multithreading.eight;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Huang Guojun
 * @Date 2019/8/14
 * @Discription
 */
public class UseSingleConditionWaitNotify {
    public static void main(String[] args) throws InterruptedException {
             MyService myService = new MyService();
             ThreadA threadA =  new ThreadA(myService);
             threadA.start();
             Thread.sleep(1000);
             myService.signal();
    }


    static class MyService {
        private Lock lock = new ReentrantLock();
        public Condition condition = lock.newCondition();

        public void await() {
            lock.lock();
            System.out.println("await 时间为" + System.currentTimeMillis());
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("这是condition.await()方法之后的语句，condition.signal()方法之后我才被执行");
            lock.unlock();
        }


        public void signal() throws InterruptedException {
            lock.lock();
            try {
                System.out.println("signal时间为" + System.currentTimeMillis());
                condition.signal();
                Thread.sleep(3000);
                System.out.println("这是condition.signal()方法之后的语句");
            } finally {
                lock.unlock();
            }

        }
    }


    public static class ThreadA extends Thread{
        private MyService myService;

        public ThreadA(MyService myService) {
            super();
            this.myService = myService;
        }

        @Override
        public void run() {
           myService.await();
        }
    }
}
