package designmodde.builder;

import lombok.Builder;
import lombok.Data;

/**
 * @Author Huang Guojun
 * @Date 2019/7/8
 * @Discription
 */
@Builder
@Data
public class Car {
    private String color;
    private String material;
    private String year;
}
