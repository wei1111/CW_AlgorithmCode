package thread.demo1;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/28 21:16
 * @Description:
 */
public class Demo1 {
    protected void show1() {
        System.out.println("demo1 show1");
        show3();
    }

    private void show2() {
        System.out.println("demo1 show2");
    }

    public void show3() {
        System.out.println("demo1 show3");
    }

    private static class Inner {
        int s1;
        static int s2;

        public Inner(int s1) {
            this.s1 = s1;
        }
    }

    @Test
    public void test() {
        Inner inner1 = new Inner(1);
        Inner inner2 = new Inner(2);
        Inner.s2 = 3;
        System.out.println(inner1.s1);
        System.out.println(inner1.s2);
        System.out.println(inner1);

        System.out.println();

        System.out.println(inner2.s1);
        System.out.println(inner2.s2);
        System.out.println(inner2);
    }
}
