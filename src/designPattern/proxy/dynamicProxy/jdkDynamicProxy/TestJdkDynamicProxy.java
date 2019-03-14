package designPattern.proxy.dynamicProxy.jdkDynamicProxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @Author: wei1
 * @Date: Create in 2018/10/24 14:38
 * @Description:
 */
public class TestJdkDynamicProxy {
    //我们要代理的对象
    TargetObject targetObject = new TargetObject();

    //我们对代理类方法的代理方法
    MyInvocationHandler myInvocationHandler = new MyInvocationHandler(targetObject);

    @Test
    public void testProxy() {
        System.out.println("我是TestJdkDynamicProxy");

        //$Proxy4 cannot be cast to designPattern.proxy.dynamicProxy.jdkDynamicProxy.TargetObject
//        TargetObject proxyInstance = (TargetObject)Proxy.newProxyInstance(targetObject.getClass()
//                        .getClassLoader(),
//                targetObject.getClass()
//                        .getInterfaces(), myInvocationHandler);

        TargetInterface proxyInstance =
                (TargetInterface) Proxy.newProxyInstance(targetObject.getClass()
                                .getClassLoader(),
                        targetObject.getClass()
                                 .getInterfaces(), myInvocationHandler);
        proxyInstance.business();
    }
}
