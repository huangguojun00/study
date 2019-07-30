package designmodde.publishsubscribe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @Author Huang Guojun
 * @Date 2019/7/30
 * @Discription
 */
@Component
public class WeatherPublisher {
    @Autowired
    private ApplicationContext applicationContext;

    public void pushListener(String weather){
        applicationContext.publishEvent(new WeatherEvent(this,weather));
    }
}
