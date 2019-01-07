package thread;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: wei1
 * @Date: Create in 2018/10/11 20:47
 * @Description: 有四个线程1、2、3、4。线程1的功能就是输出1，线程2的功能就是输出2，以此类推。
 * 现在有四个文件ABCD。初始都为空。现要让四个文件呈如下格式：
 * A. 1 2 3 4 1 2....
 * B. 2 3 4 1 2 3....
 * C. 3 4 1 2 3 4....
 * D. 4 1 2 3 4 1....
 * 请设计程序。
 * 4个线程同时执行，每个负责向文件输出1 2 3 4
 * 就是线程1向Ａ B C D 四个文件输出1
 * 就是线程2向Ａ B C D 四个文件输出2
 * 就是线程3向Ａ B C D 四个文件输出3
 * 就是线程4向Ａ B C D 四个文件输出4
 * 开始就是用Reentrant的一个锁对应多个condition来控制流程，但是这样是一个线程在写，3个在等没有意义
 * 现在发现这个是有执行顺序的,注意每个IO完成的时间都不一样，注意sleep一会
 * 线程1： A -> D -> C -> B
 * 线程2： B -> A -> D -> C
 * 线程3： C -> B -> A -> D
 * 线程4： D -> C -> B -> A
 */
public class ThreadOrderRun6 {
    HashMap<Character, FileWriter> fwhm = new HashMap<>();
    HashMap<Character, Lock> lockhm = new HashMap<>();
    HashMap<Character, AtomicInteger> fidhm = new HashMap<>();
    HashMap<String, Condition> chm = new HashMap<>();
    CountDownLatch start = new CountDownLatch(1);

    public ThreadOrderRun6(char[] chs) throws IOException {
        //初始化创建文件A Ｂ C D
        int x = 0;
        for (char ch : chs) {
            File file = new File(ch + ".txt");
            if (file != null) {
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
            }
            fwhm.put(ch, new FileWriter(file));
            lockhm.put(ch, new ReentrantLock());
            if (x == 0) {
                fidhm.put(ch, new AtomicInteger(1));
                x++;
            } else {
                fidhm.put(ch, new AtomicInteger(chs.length + 1 - x));
                x++;
            }
        }
        for (char ch : chs) {
            for (int j = 1; j <= chs.length; j++) {
                chm.put("" + ch + j, lockhm.get(ch).newCondition());
            }
        }
    }


    private void firstRun() throws IOException, InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName);
        String[] strs = threadName.split("_");
        char[] chs = strs[0].toCharArray();
        int i = Integer.parseInt(strs[1]) + 1;
        start.await();
        while (true) {
            for (int j = 0; j < size; j++) {
                Lock lock = lockhm.get(chs[j]);
                lock.lock();
                try {
                    while (fidhm.get(chs[j]).get() != i) {
                        chm.get("" + chs[j] + i).await();
                    }
                    fileWriter(chs[j], i + " ");

                    if (i == size) {
                        fidhm.get(chs[j]).getAndSet(1);
                    } else {
                        fidhm.get(chs[j]).getAndSet(i + 1);
                    }

//                    System.out.println("signal:" + chs[j] + fidhm.get(chs[j]).get());
                    chm.get("" + chs[j] + fidhm.get(chs[j]).get()).signal();
                } finally {
                    lock.unlock();
                }
            }
        }

    }


    private void fileWriter(char fileName, String str) throws IOException {
        fwhm.get(fileName).write(str);
        fwhm.get(fileName).flush();
    }

    public static int size = 4;

    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        char start = 'A';
        stringBuilder.append(start);
        for (int i = 1; i < size; i++) {
            stringBuilder.append((char) (start + size - i));
        }
        String order = stringBuilder.toString();
        ThreadOrderRun6 threadOrderRun6 = new ThreadOrderRun6(order.toCharArray());

        for (int i = 0; i < size; i++) {
            String sub1 = order.substring(0, size - i);
            String sub2 = order.substring(size - i, size);
            String threadName = sub2 + sub1 + "_" + i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        threadOrderRun6.firstRun();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, threadName).start();
        }

        threadOrderRun6.start.countDown();
    }

    @Test
    public void test() {
        String str = "ABCD";
        for (int i = 0; i < str.length(); i++) {
            String sub1 = str.substring(0, i);
            String sub2 = str.substring(i, str.length());
            System.out.println(sub1 + " " + sub2);
        }
    }
}
