package juc.vola;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: wei1
 * @Date: Create in 2019/1/20 12:15
 * @Description:
 */
public class VolatileDemo1 {

    public static volatile int n = 0;
    public static int clientTotal = 5000;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(n);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        ExecutorService executorService = Executors.newFixedThreadPool(200);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();

        System.out.println(n);
    }

    public static void add() throws InterruptedException {
        n++;
//        Thread.sleep(10);
        System.out.println(Thread.currentThread().getName() + "---> " + n);
    }

    public static void reduce() throws InterruptedException {
        n--;
        Thread.sleep(10);
        System.out.println(Thread.currentThread().getName() + "---> " + n);
    }

}
