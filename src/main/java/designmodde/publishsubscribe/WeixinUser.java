package designmodde.publishsubscribe;

import lombok.Data;

/**
 * @Author Huang Guojun
 * @Date 2019/5/25
 * @Discription
 */
@Data
public class WeixinUser implements Observer {
    private String name;

    public WeixinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}
