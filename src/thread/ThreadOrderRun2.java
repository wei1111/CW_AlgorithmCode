package thread;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();
    Lock lock3 = new ReentrantLock();
    Lock lock4 = new ReentrantLock();

    String[] fileNames = {"A", "B", "C", "D"};
    volatile boolean[] fileCanWrite = {true, true, true, true};
    Condition condition1 = lock1.newCondition();
    Condition condition2 = lock1.newCondition();
    Condition condition3 = lock1.newCondition();
    Condition condition4 = lock1.newCondition();
//    Condition condition2 = lock2.newCondition();
//    Condition condition3 = lock3.newCondition();
//    Condition condition4 = lock4.newCondition();

    File fileA = new File("A.txt");
    File fileB = new File("B.txt");
    File fileC = new File("C.txt");
    File fileD = new File("D.txt");
    FileWriter fwA;
    FileWriter fwB;
    FileWriter fwC;
    FileWriter fwD;

    public ThreadOrderRun2() throws IOException {
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

    @Test
    public void test1() throws IOException {
        fileA.createNewFile();
    }

    volatile int needFileId1 = 0;
    volatile int needFileId2 = 1;
    volatile int needFileId3 = 2;
    volatile int needFileId4 = 3;

    private void firstRun() {
        while (true) {
            lock1.lock();
            try {
                if (!fileCanWrite[needFileId1]) {
                    condition1.await();
                }
                fileCanWrite[needFileId1] = !fileCanWrite[needFileId1];

                fileWriter("file" + fileNames[needFileId1], "1 ");

                int formerNeed = needFileId1;
                needFileId1 = (needFileId1 + 1) % 4;
                fileCanWrite[formerNeed] = !fileCanWrite[formerNeed];
                if (needFileId2 == formerNeed) {
                    condition2.signal();
                }
                if (needFileId3 == formerNeed) {
                    condition3.signal();
                }
                if (needFileId4 == formerNeed) {
                    condition4.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                lock1.unlock();
            }
        }
    }

    private void secondRun() {
        while (true) {
//            lock2.lock();
            lock1.lock();
            try {
                if (!fileCanWrite[needFileId2]) {
                    condition2.await();
                }
                fileCanWrite[needFileId2] = !fileCanWrite[needFileId2];
                fileWriter("file" + fileNames[needFileId2], "2 ");
                int formerNeed = needFileId2;
                needFileId2 = (needFileId2 + 1) % 4;
                fileCanWrite[formerNeed] = !fileCanWrite[formerNeed];
                if (needFileId1 == formerNeed) {
                    condition1.signal();
                }
                if (needFileId3 == formerNeed) {
                    condition3.signal();
                }
                if (needFileId4 == formerNeed) {
                    condition4.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                lock1.unlock();
            }
        }
    }

    private void thirdRun() {
        while (true) {
//            lock3.lock();
            lock1.lock();
            try {
                if (!fileCanWrite[needFileId3]) {
                    condition3.await();
                }
                fileCanWrite[needFileId3] = !fileCanWrite[needFileId3];
                fileWriter("file" + fileNames[needFileId3], "3 ");
                int formerNeed = needFileId3;
                needFileId3 = (needFileId3 + 1) % 4;
                fileCanWrite[formerNeed] = !fileCanWrite[formerNeed];
                if (needFileId1 == formerNeed) {
                    condition1.signal();
                }
                if (needFileId2 == formerNeed) {
                    condition2.signal();
                }
                if (needFileId4 == formerNeed) {
                    condition4.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
//                lock3.unlock();
                lock1.unlock();
            }
        }
    }

    private void fourthRun() {
        while (true) {
//            lock4.lock();
            lock1.lock();
            try {
                if (!fileCanWrite[needFileId4]) {
                    condition4.await();
                }
                fileCanWrite[needFileId4] = !fileCanWrite[needFileId4];
                fileWriter("file" + fileNames[needFileId4], "4 ");
                int formerNeed = needFileId4;
                needFileId4 = (needFileId4 + 1) % 4;
                fileCanWrite[formerNeed] = !fileCanWrite[formerNeed];
                if (needFileId1 == formerNeed) {
                    condition1.signal();
                }
                if (needFileId2 == formerNeed) {
                    condition2.signal();
                }
                if (needFileId3 == formerNeed) {
                    condition3.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                lock1.unlock();
            }
        }
    }

    private void fileWriter(String fileName, String ch) throws IOException {
        if (fileName == null) {
            return;
        }
        if (fileName.equals("fileA")) {
            fwA.write(ch);
            fwA.flush();
        }
        if (fileName.equals("fileB")) {
            fwB.write(ch);
            fwB.flush();
        }
        if (fileName.equals("fileC")) {
            fwC.write(ch);
            fwC.flush();
        }
        if (fileName.equals("fileD")) {
            fwD.write(ch);
            fwD.flush();
        }
    }

//    @Test
//    public void testOrder() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                firstRun(5);
//            }
//        }, "thread---1").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                secondRun(5);
//            }
//        }, "thread---2").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                thirdRun(5);
//            }
//        }, "thread---3").start();
//    }

    public static void main(String[] args) throws IOException {
        ThreadOrderRun2 threadOrderRun2 = new ThreadOrderRun2();
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadOrderRun2.firstRun();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadOrderRun2.secondRun();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadOrderRun2.thirdRun();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadOrderRun2.fourthRun();
            }
        }).start();
    }
}
