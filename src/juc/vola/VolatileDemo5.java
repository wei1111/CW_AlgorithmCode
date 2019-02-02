package juc.vola;

import java.util.concurrent.*;

/**
 * @Author: wei1
 * @Date: Create in 2019/1/20 12:15
 * @Description:
 */
public class VolatileDemo5 {

    public static BlockingQueue n = new LinkedBlockingDeque();
    public static int clientTotal = 5000;
    public static int currenetTotal = 200;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(n.size());
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

        System.out.println(n.size());
    }

    public static void add() throws InterruptedException {
        n.put(1);
        System.out.println(Thread.currentThread().getName() + "---> " + n.size());
    }

    public static void reduce() throws InterruptedException {
        n.take();
        System.out.println(Thread.currentThread().getName() + "---> " + n.size());
    }

}
