package designmodde.dynamicproxy;

/**
 * @Author Huang Guojun
 * @Date 2019/7/8
 * @Discription
 */
public class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + "吃了好多");
    }
}
