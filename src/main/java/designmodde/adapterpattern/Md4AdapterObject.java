package designmodde.adapterpattern;

/**
 * @Author Huang Guojun
 * @Date 2019/8/4
 * @Discription
 */
public class Md4AdapterObject implements Target{
    private Target target;

    public Md4AdapterObject(Target target) {
        this.target = target;
    }

    @Override
    public void connection() {
        System.out.println("插入 type-c 转接头");
        target.connection();
    }
}
