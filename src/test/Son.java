package test;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2019/1/15 21:01
 * @Description:
 */
public class Son extends Father {
    @Override
    public void show1() {
        super.show1();
    }

//    @Override
//    private void show2() {
//        super.show2();
//        System.out.println("public son show2");
//    }

    public void show3() {
        System.out.println("public son show3");
    }

    @Test
    public void test() {
        show3();
    }
}
