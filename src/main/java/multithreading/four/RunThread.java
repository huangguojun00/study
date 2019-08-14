package multithreading.four;

/**
 * @Author Huang Guojun
 * @Date 2019/8/13
 * @Discription
 */
public class RunThread extends Thread{
    private volatile boolean isRunning = true;
    int m;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void run() {
        System.out.println("进入run");
        while (isRunning == true){
            int a =2 ;
            int b =3;
            int c = a+b;
            m =c;
        }
        System.out.println(m);
        System.out.println("线程被停止了");
    }
}
