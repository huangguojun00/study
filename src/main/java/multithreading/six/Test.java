package multithreading.six;

/**
 * @Author Huang Guojun
 * @Date 2019/8/13
 * @Discription
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        ThreadA threadA = new ThreadA(o);
        threadA.start();

        Thread.sleep(50);

        ThreadB threadB = new ThreadB(o);
        threadB.start();
    }
}
