package designmodde.builder;

import com.alibaba.fastjson.JSON;

/**
 * @Author Huang Guojun
 * @Date 2019/7/8
 * @Discription
 */
public class Test {
    public static void main(String[] args) {
//        Person build = new Person.Builder("huang").ears("xiao").mouth("da").build();
//        System.out.println(build.toString());
        Car car = new Car.CarBuilder().color("red").material("gang").build();
        System.out.println(car.toString());
    }
}
