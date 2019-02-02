package juc.myBlockQueue;

import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author: wei1
 * @Date: Create in 2019/1/20 14:25
 * @Description: 使用锁实现
 */
public class BlockQueueDemo1 {
    LinkedList<Integer> list = new LinkedList();

    public int take() throws InterruptedException {
        synchronized (list) {
            System.out.println(Thread.currentThread().getName() + "-- reduce --> " + list.size());
            while (list.size() == 0) {
                System.out.println("空了");
                list.wait();
            }
            list.notifyAll();
            return list.remove();
        }
    }

    public void put(Integer i) throws InterruptedException {
        synchronized (list) {
            System.out.println(Thread.currentThread().getName() + "-- add --> " + list.size());
            while (list.size() == 10) {
                System.out.println("满了");
                list.wait();
            }
            list.notifyAll();
            list.add(i);
        }
    }

    public int size() {
        synchronized (list) {
            return list.size();
        }
    }


    public static int clientTotal = 500;
    public static int currenetTotal = 200;

    public static void main(String[] args) throws InterruptedException {
        BlockQueueDemo1 n = new BlockQueueDemo1();
        System.out.println(n.size());
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal * 2);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(clientTotal * 2);

        for (int i = 0; i < clientTotal; i++) {
            System.out.println("----------- " + i + " -----------");

            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add(n);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }

        System.out.println("----------------------");

        for (int i = 0; i < clientTotal; i++) {
            System.out.println("----------- " + i);
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    reduce(n);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }

        System.out.println("----------------------");
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("----------------------");

        System.out.println(n.size());
    }

    public static void add(BlockQueueDemo1 n) throws InterruptedException {
        n.put(1);
    }

    public static void reduce(BlockQueueDemo1 n) throws InterruptedException {
        n.take();
    }
}
