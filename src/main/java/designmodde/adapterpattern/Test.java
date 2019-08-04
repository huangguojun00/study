package designmodde.adapterpattern;

/**
 * @Author Huang Guojun
 * @Date 2019/8/4
 * @Discription 结构模型的一种 把一个类的接口变成客户端期待的另一个接口，从而使原本不匹配的两个接口可以在一期工作
 */
public class Test {
    public static void main(String[] args) {
        Target md5dataline = new MD5dataline();
        md5dataline.connection();
        MD5Adapter md5Adapter = new MD5Adapter();
        md5Adapter.connection();


        Md4AdapterObject md4AdapterObject = new Md4AdapterObject(new MD5dataline());
        md4AdapterObject.connection();
    }
}
