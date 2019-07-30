package designmodde.publishsubscribe;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author Huang Guojun
 * @Date 2019/7/30
 * @Discription
 */
@Component
public class WeatherListener implements ApplicationListener<WeatherEvent> {



    @Override
    public void onApplicationEvent(WeatherEvent weatherEvent) {
        System.out.println(weatherEvent.getWeather());
    }
}
