package multithreading.seven;

/**
 * @Author Huang Guojun
 * @Date 2019/8/14
 * @Discription
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.join(1000);
        System.out.println("我想当threadTest对象执行完毕后我再执行");
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我想先执行的");
        }
    }

}
