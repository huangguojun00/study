package designmodde.adapterpattern;

/**
 * @Author Huang Guojun
 * @Date 2019/8/4
 * @Discription
 */
public class MD5Adapter extends MD4DataLine implements Target {
    @Override
    public void connection() {
        System.out.println("插入 type-c 转接头");
        super.connection();
    }
}
