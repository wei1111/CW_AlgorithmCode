package thread;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
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
public class ThreadOrderRun5 {
    File fileA = new File("A.txt");
    File fileB = new File("B.txt");
    File fileC = new File("C.txt");
    File fileD = new File("D.txt");
    FileWriter fwA;
    FileWriter fwB;
    FileWriter fwC;
    FileWriter fwD;
    volatile int fileAid = 1;
    volatile int fileBid = 2;
    volatile int fileCid = 3;
    volatile int fileDid = 4;
    ReentrantLock lockA = new ReentrantLock();
    ReentrantLock lockB = new ReentrantLock();
    ReentrantLock lockC = new ReentrantLock();
    ReentrantLock lockD = new ReentrantLock();
    Condition conditionA1 = lockA.newCondition();
    Condition conditionA2 = lockA.newCondition();
    Condition conditionA3 = lockA.newCondition();
    Condition conditionA4 = lockA.newCondition();

    Condition conditionB1 = lockB.newCondition();
    Condition conditionB2 = lockB.newCondition();
    Condition conditionB3 = lockB.newCondition();
    Condition conditionB4 = lockB.newCondition();

    Condition conditionC1 = lockC.newCondition();
    Condition conditionC2 = lockC.newCondition();
    Condition conditionC3 = lockC.newCondition();
    Condition conditionC4 = lockC.newCondition();

    Condition conditionD1 = lockD.newCondition();
    Condition conditionD2 = lockD.newCondition();
    Condition conditionD3 = lockD.newCondition();
    Condition conditionD4 = lockD.newCondition();

    CountDownLatch start = new CountDownLatch(1);

    public ThreadOrderRun5() throws IOException {
        //初始化创建文件A Ｂ C D
        if (fileA.exists() || fileB.exists() || fileC.exists() || fileD.exists()) {
            fileA.delete();
            fileB.delete();
            fileC.delete();
            fileD.delete();
        }
        fileA.createNewFile();
        fileB.createNewFile();
        fileC.createNewFile();
        fileD.createNewFile();
        fwA = new FileWriter(fileA);
        fwB = new FileWriter(fileB);
        fwC = new FileWriter(fileC);
        fwD = new FileWriter(fileD);
    }

    private void firstRun(String str) throws IOException, InterruptedException {
        start.await();
        while (true) {
            lockA.lock();
            try {
                while (fileAid != 1) {
                    conditionA1.await();
                }
                fileWriter("fileA", str);
                fileAid = 2;
                conditionA2.signal();
            } finally {
                lockA.unlock();
            }

            lockD.lock();
            try {
                while (fileDid != 1) {
                    conditionD1.await();
                }
                fileWriter("fileD", str);
                fileDid = 2;
                conditionD2.signal();
            } finally {
                lockD.unlock();
            }

            lockC.lock();
            try {
                while (fileCid != 1) {
                    conditionC1.await();
                }
                fileWriter("fileC", str);
                fileCid = 2;
                conditionC2.signal();
            } finally {
                lockC.unlock();
            }

            lockB.lock();
            try {
                while (fileBid != 1) {
                    conditionB1.await();
                }
                fileWriter("fileB", str);
                fileBid = 2;
                conditionB2.signal();
            } finally {
                lockB.unlock();
            }

        }

    }

    private void secondRun(String str) throws IOException, InterruptedException {
        start.await();
        while (true) {
            lockB.lock();
            try {
                while (fileBid != 2) {
                    conditionB2.await();
                }
                fileWriter("fileB", str);
                fileBid = 3;
                conditionB3.signal();
            } finally {
                lockB.unlock();
            }

            lockA.lock();
            try {
                while (fileAid != 2) {
                    conditionA2.await();
                }
                fileWriter("fileA", str);
                fileAid = 3;
                conditionA3.signal();
            } finally {
                lockA.unlock();
            }

            lockD.lock();
            try {
                while (fileDid != 2) {
                    conditionD2.await();
                }
                fileWriter("fileD", str);
                fileDid = 3;
                conditionD3.signal();
            } finally {
                lockD.unlock();
            }

            lockC.lock();
            try {
                while (fileCid != 2) {
                    conditionC2.await();
                }
                fileWriter("fileC", str);
                fileCid = 3;
                conditionC3.signal();
            } finally {
                lockC.unlock();
            }

        }
    }

    private void thirdRun(String str) throws IOException, InterruptedException {
        start.await();
        while (true) {
            lockC.lock();
            try {
                while (fileCid != 3) {
                    conditionC3.await();
                }
                fileWriter("fileC", str);
                fileCid = 4;
                conditionC4.signal();
            } finally {
                lockC.unlock();
            }

            lockB.lock();
            try {
                while (fileBid != 3) {
                    conditionB3.await();
                }
                fileWriter("fileB", str);
                fileBid = 4;
                conditionB4.signal();
            } finally {
                lockB.unlock();
            }

            lockA.lock();
            try {
                while (fileAid != 3) {
                    conditionA3.await();
                }
                fileWriter("fileA", str);
                fileAid = 4;
                conditionA4.signal();
            } finally {
                lockA.unlock();
            }

            lockD.lock();
            try {
                while (fileDid != 3) {
                    conditionD3.await();
                }
                fileWriter("fileD", str);
                fileDid = 4;
                conditionD4.signal();
            } finally {
                lockD.unlock();
            }

        }
    }

    private void fourthRun(String str) throws IOException, InterruptedException {
        start.await();
        while (true) {
            lockD.lock();
            try {
                while (fileDid != 4) {
                    conditionD4.await();
                }
                fileWriter("fileD", str);
                fileDid = 1;
                conditionD1.signal();
            } finally {
                lockD.unlock();
            }

            lockC.lock();
            try {
                while (fileCid != 4) {
                    conditionC4.await();
                }
                fileWriter("fileC", str);
                fileCid = 1;
                conditionC1.signal();
            } finally {
                lockC.unlock();
            }

            lockB.lock();
            try {
                while (fileBid != 4) {
                    conditionB4.await();
                }
                fileWriter("fileB", str);
                fileBid = 1;
                conditionB1.signal();
            } finally {
                lockB.unlock();
            }

            lockA.lock();
            try {
                while (fileAid != 4) {
                    conditionA4.await();
                }
                fileWriter("fileA", str);
                fileAid = 1;
                conditionA1.signal();
            } finally {
                lockA.unlock();
            }

        }
    }


    private void fileWriter(String fileName, String str) throws IOException {
        if (fileName == null) {
            return;
        }
        if (fileName.equals("fileA")) {
            fwA.write(str);
            fwA.flush();
        }
        if (fileName.equals("fileB")) {
            fwB.write(str);
            fwB.flush();
        }
        if (fileName.equals("fileC")) {
            fwC.write(str);
            fwC.flush();
        }
        if (fileName.equals("fileD")) {
            fwD.write(str);
            fwD.flush();
        }
    }

    public static void main(String[] args) throws IOException {
        ThreadOrderRun5 threadOrderRun5 = new ThreadOrderRun5();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threadOrderRun5.firstRun("1 ");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threadOrderRun5.secondRun("2 ");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threadOrderRun5.thirdRun("3 ");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threadOrderRun5.fourthRun("4 ");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        threadOrderRun5.start.countDown();
    }
}
