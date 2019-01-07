package thread.demo1;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/28 20:43
 * @Description:
 */
public class Demo2 extends Demo1 {
//    @Override
//    protected void show1() {
//        System.out.println("demo2 show1");
//    }

    private void show2() {
        System.out.println("demo2 show2");
    }

    @Override
    public void show3() {
        System.out.println("demo2 show3");
    }

    @Test
    public void test() {
        Demo2 demo2 = new Demo2();
        Demo1 demo1 = new Demo1();
        demo2.show1();
    }

}

