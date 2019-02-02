package juc.vola;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author: wei1
 * @Date: Create in 2019/1/20 12:15
 * @Description:
 */
public class VolatileDemo3 {

    public static volatile int n = 0;
    public static int clientTotal = 5000;
    public static int currenetTotal = 200;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(n);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(currenetTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
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
        System.out.println(Thread.currentThread().getName() + "---> " + n);
    }

    public static void reduce() throws InterruptedException {
        n--;
        System.out.println(Thread.currentThread().getName() + "---> " + n);
    }

}
