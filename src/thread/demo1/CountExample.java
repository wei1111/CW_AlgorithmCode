package thread.demo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/12 20:00
 * @Description:
 */
public class CountExample {
    private static int threadSize = 200;
    private static int loopSize = 10000;
    static int j = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(threadSize);
        for (int i = 0; i < loopSize; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        add();
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println(j);
        executorService.shutdown();
    }

    private static void add() {
        j++;
    }
}
