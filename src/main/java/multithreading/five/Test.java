package multithreading.five;

/**
 * @Author Huang Guojun
 * @Date 2019/8/13
 * @Discription
 */
public class Test {
    public static void main(String[] args) {
        MyThread[] mythreadArray = new MyThread[100];
        for (int i = 0; i < 100; i++) {
            mythreadArray[i] = new MyThread();
        }

        for (int i = 0; i < 100; i++) {
            mythreadArray[i].start();
        }
    }
}
