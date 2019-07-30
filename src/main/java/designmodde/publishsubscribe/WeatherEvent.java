package designmodde.publishsubscribe;

import lombok.*;
import org.springframework.context.ApplicationEvent;

/**
 * @Author Huang Guojun
 * @Date 2019/7/30
 * @Discription
 */
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString
public class WeatherEvent extends ApplicationEvent {

    private String weather;


    public WeatherEvent(Object source, String weather) {
        super(source);
        this.weather = weather;
    }
}
