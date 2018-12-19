package thread;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: wei1
 * @Date: Create in 2018/10/11 20:47
 * @Description: 使得多线程按顺序执行
 * 思路：使用join
 */
public class ThreadOrderRun2 {
    Lock lock = new ReentrantLock();
    int number = 1;
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    private void firstRun(int n) {
        lock.lock();
        try {
            if (number != 1) {
                condition1.await();
            }
            for (int i = 0; i < n; i++) {
                System.out.println(Thread.currentThread().getName());
            }
            number = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void secondRun(int n) {
        lock.lock();
        try {
            if (number != 2) {
                condition2.await();
            }
            for (int i = 0; i < n; i++) {
                System.out.println(Thread.currentThread().getName());
            }
            number = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void thirdRun(int n) {
        lock.lock();
        try {
            if (number != 3) {
                condition1.await();
            }
            for (int i = 0; i < n; i++) {
                System.out.println(Thread.currentThread().getName());
            }
            number = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Test
    public void testOrder() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                firstRun(5);
            }
        }, "thread---1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                secondRun(5);
            }
        }, "thread---2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                thirdRun(5);
            }
        }, "thread---3").start();
    }

    @Test
    public void test() {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        Integer k = 1;
        System.out.println(i == j);
        System.out.println(i == k);
    }
}
