package designmodde.dynamicproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author Huang Guojun
 * @Date 2019/7/8
 * @Discription Cglib 代理  其实也是基于继承实现的
 */
public class TimeDynamicProxy {
    Object obj;

    Object bind(final Object target) {
        this.obj = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                long l = System.currentTimeMillis();
                Object invoke = method.invoke(target, objects);
                long l1 = System.currentTimeMillis() - l;
                System.out.println("飞了" + l1 + "毫秒");
                return invoke;
            }
        });
        return enhancer.create();
    }
}
