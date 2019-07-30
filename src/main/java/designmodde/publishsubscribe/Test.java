package designmodde.publishsubscribe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Huang Guojun
 * @Date 2019/5/25
 * @Discription
 */

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext();
        WeatherPublisher weatherPublisher = (WeatherPublisher) context.getBean("WeatherPublisher");
        weatherPublisher.pushListener("下雨");
    }
}
