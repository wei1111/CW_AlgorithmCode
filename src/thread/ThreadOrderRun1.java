package thread;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/10/11 20:47
 * @Description: 使得多线程按顺序执行
 * 思路：使用join
 */
public class ThreadOrderRun1 {
    private void order(int n) throws InterruptedException {
        Thread tmp;
        for (int i = 0; i < n; i++) {
            tmp = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "thread--" + i);
            tmp.start();
            //当我们调用某个线程的这个方法时，这个方法会挂起调用线程，
            //直到被调用线程结束执行，调用线程才会继续执行。
            tmp.join();
        }
    }

    @Test
    public void testOrder() {
        try {
            order(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
