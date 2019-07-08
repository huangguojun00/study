package designmodde.dynamicproxy;

import java.lang.reflect.Method;

/**
 * @Author Huang Guojun
 * @Date 2019/7/8
 * @Discription
 */
public interface InvocationHandler {
    void invoke(Object proxy, Method method, Object[] args);
}

