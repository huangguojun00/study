package multithreading.two;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Huang Guojun
 * @Date 2019/8/13
 * @Discription .有一个抽奖池, 该抽奖池中存放了奖励的金额, 该抽奖池用一个数组int[] arr = {10,5,20,50,100,200,500,800,2,80,300};
 * 创建两个抽奖箱(线程)设置线程名称分别为“抽奖箱1”，“抽奖箱2”，随机从arr数组中获取奖项元素并打印在控制台上,格式如下:
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {10,5,20,50,100,200,500,800,2,80,300};
        Thread thread1 = new Thread(new LotteryBox(arr),"抽奖箱1");
        Thread thread2 = new Thread(new LotteryBox(arr),"抽奖箱2");
        thread1.start();
        thread2.start();

    }



    static class LotteryBox implements Runnable{

        private final int[] arr;

        public LotteryBox(int[] arr) {
            this.arr = arr;
        }

        @Override
        public void run() {
            synchronized (arr){
                for (int i = 0; i < 100 ;i++) {
                    int j = new Random().nextInt(arr.length);
                    System.out.println(arr[j] +"----------------"+Thread.currentThread().getName());
                    if (i%3!=0){
                        arr.notifyAll();
                        try {
                            arr.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }

            }

        }
    }
}
