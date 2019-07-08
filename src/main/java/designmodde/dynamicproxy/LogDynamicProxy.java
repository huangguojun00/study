package designmodde.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author Huang Guojun
 * @Date 2019/7/8
 * @Discription  InvocationHandler 动态代理  基于反射实现
 */
public class LogDynamicProxy implements InvocationHandler {
    private Object object;

    Object bind(Object object){
        this.object = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Bird fly start...");
        Object res = method.invoke(object, args);
        System.out.println("Bird fly end...");
        return res;
    }
}
