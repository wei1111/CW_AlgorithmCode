package designPattern.proxy.dynamicProxy.jdkDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: wei1
 * @Date: Create in 2018/10/24 14:33
 * @Description: 这个类就是jdk动态代理类proxy调用的方法，在invoke中对我们的目标类进行了代理
 */
public class MyInvocationHandler implements InvocationHandler {
    Object target;

    public MyInvocationHandler(Object o) {
        this.target = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是MyInvocationHandler，我在这里开启了事务哦");
        method.invoke(target, args);
        System.out.println("我是MyInvocationHandler，我在这里关闭了事务哦");
        return null;
    }
}
