package thread.demo1;

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


}
