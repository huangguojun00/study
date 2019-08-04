package designmodde.adapterpattern;

/**
 * @Author Huang Guojun
 * @Date 2019/8/4
 * @Discription
 */
public class MD5dataline implements Target {
    @Override
    public void connection() {
        System.out.println("使用小米5数据线连接");
    }
}
