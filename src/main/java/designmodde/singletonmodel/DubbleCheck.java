package designmodde.singletonmodel;

/**
 * @Author Huang Guojun
 * @Date 2019/8/4
 * @Discription 双重检查锁机制
 */
public class DubbleCheck {
    volatile private static DubbleCheck dubbleCheck = null;

    private DubbleCheck() {
    }

    public static DubbleCheck getInstance() {
        if (dubbleCheck == null) {
            synchronized (DubbleCheck.class) {
                if (dubbleCheck == null) {
                    dubbleCheck = new DubbleCheck();
                }
            }
        }
        return dubbleCheck;
    }
}
