package multithreading.one;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Huang Guojun
 * @Date 2019/8/11
 * @Discription 创建两个线程，其中一个输出1-52，另外一个输出A-Z。输出格式要求：12A 34B 56C 78D
 */
public class Test {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Object o = new Object();
        pool.submit(new Number(o));
        pool.submit(new Word(o));



    }

    static class Number implements Runnable {

        private final Object object;

        public Number(Object object) {
            this.object = object;
        }

        @Override
        public void run() {
            synchronized (object) {
                for (int i = 1; i <= 52; i++) {
                    System.out.println(i + "-----------" + Thread.currentThread().getName());
                    if (i % 2 == 0) {
                        object.notifyAll();
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }


    static class Word implements Runnable {
        private final Object object;

        public Word(Object object) {
            this.object = object;
        }

        @Override
        public void run() {
            synchronized (object) {
                for (int i = 'A'; i <= 'A' + 26; i++) {
                    System.out.println(((char) i) + "-----------" + Thread.currentThread().getName());
                    object.notifyAll();
                    if (i != ('A' + 26)) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }


}
