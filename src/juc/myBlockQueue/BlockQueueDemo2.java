package juc.myBlockQueue;

import org.junit.Test;

import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author: wei1
 * @Date: Create in 2019/1/20 14:25
 * @Description: 使用信号量实现
 */
public class BlockQueueDemo2 {
    LinkedList<Integer> list = new LinkedList();

    Semaphore sync = new Semaphore(0);
    Semaphore send = new Semaphore(1);
    Semaphore recv = new Semaphore(0);

    public int take() throws InterruptedException {
        recv.acquire();
        System.out.println("take-->recv-->" + recv.toString());
        Integer t = list.remove();
//        sync.release();
//        System.out.println("take-->sync-->" + sync.toString());
        send.release();
        System.out.println("take-->send-->" + send.toString());
        sync.release();
        return t;
    }

    public void put(Integer i) throws InterruptedException {
        send.acquire();
        System.out.println("put-->send-->" + send.toString());
        list.add(i);
        recv.release();
        System.out.println("put-->recv-->" + recv.toString());
        sync.acquire();
    }

    @Test
    public void test() throws InterruptedException {
        put(1);
        System.out.println("test put");
//        take();
//        System.out.println("test take");
    }

    public int size() {
        synchronized (list) {
            return list.size();
        }
    }


    public static int clientTotal = 500;
    public static int currenetTotal = 200;

    public static void main(String[] args) throws InterruptedException {
        BlockQueueDemo2 n = new BlockQueueDemo2();
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

    public static void add(BlockQueueDemo2 n) throws InterruptedException {
        n.put(1);
    }

    public static void reduce(BlockQueueDemo2 n) throws InterruptedException {
        n.take();
    }
}
