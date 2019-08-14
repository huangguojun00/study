package multithreading.five;

/**
 * @Author Huang Guojun
 * @Date 2019/8/13
 * @Discription
 */
public class MyThread extends Thread {
   static int count;

    @Override
    public void run() {
       addCount();

    }
     private  void addCount() {
        for (int i = 0; i < 100; i++) {
            count=i;
        }
        System.out.println("count=" + count);
    }

}
