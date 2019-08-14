package multithreading.four;

/**
 * @Author Huang Guojun
 * @Date 2019/8/13
 * @Discription
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        RunThread runThread = new RunThread();
        runThread.start();
        Thread.sleep(1000);
        runThread.setRunning(false);
        System.out.println("已赋值为false");
    }
}
