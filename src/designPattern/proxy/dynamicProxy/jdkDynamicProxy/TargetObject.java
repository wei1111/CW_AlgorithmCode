package designPattern.proxy.dynamicProxy.jdkDynamicProxy;

/**
 * @Author: wei1
 * @Date: Create in 2018/10/24 14:29
 * @Description:
 */
public class TargetObject implements TargetInterface {

    @Override
    public void business() {
        System.out.println("我是TargetObujet");
    }
}
