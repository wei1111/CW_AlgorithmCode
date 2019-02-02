package juc.vola;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: wei1
 * @Date: Create in 2019/1/20 12:15
 * @Description:
 */
public class VolatileDemo4 {

    public static AtomicInteger n = new AtomicInteger(0);
    public static int clientTotal = 5000;
    public static int currenetTotal = 200;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(n.get());
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

        System.out.println(n.get());
    }

    public static void add() throws InterruptedException {
        n.getAndAdd(1);
        System.out.println(Thread.currentThread().getName() + "---> " + n.get());
    }

    public static void reduce() throws InterruptedException {
        n.getAndAdd(-1);
        System.out.println(Thread.currentThread().getName() + "---> " + n.get());
    }

}
