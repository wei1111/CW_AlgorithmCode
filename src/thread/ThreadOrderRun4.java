package thread;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

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
public class ThreadOrderRun4 {
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
    CountDownLatch start = new CountDownLatch(1);

    public ThreadOrderRun4() throws IOException {
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
//            try {
//                lock1.lock();
//                if (lock1id != 1) {
//                    condition11.await();
//                }
//                fileWriter("fileA", "1 ");
//                lock1id = 2;
//                condition12.signal();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                lock1.unlock();
//            }
            while (fileAid != 1) {

            }
            synchronized (fileA) {
                fileWriter("fileA", str);
                fileAid = 2;
            }

            while (fileDid != 1) {

            }
            synchronized (fileD) {
                fileWriter("fileD", str);
                fileDid = 2;
            }

            while (fileCid != 1) {

            }
            synchronized (fileC) {
                fileWriter("fileC", str);
                fileCid = 2;
            }

            while (fileBid != 1) {

            }
            synchronized (fileB) {
                fileWriter("fileB", str);
                fileBid = 2;
            }

        }

    }

    private void secondRun(String str) throws IOException, InterruptedException {
        start.await();
        while (true) {
            while (fileBid != 2) {

            }
            synchronized (fileB) {
                fileWriter("fileB", str);
                fileBid = 3;
            }

            while (fileAid != 2) {
            }
            synchronized (fileA) {
                fileWriter("fileA", str);
                fileAid = 3;
            }

            while (fileDid != 2) {

            }
            synchronized (fileD) {
                fileWriter("fileD", str);
                fileDid = 3;
            }

            while (fileCid != 2) {

            }
            synchronized (fileC) {
                fileWriter("fileC", str);
                fileCid = 3;
            }

        }
    }

    private void thirdRun(String str) throws IOException, InterruptedException {
        start.await();
        while (true) {
            while (fileCid != 3) {

            }
            synchronized (fileC) {
                fileWriter("fileC", str);
                fileCid = 4;
            }

            while (fileBid != 3) {

            }
            synchronized (fileB) {
                fileWriter("fileB", str);
                fileBid = 4;
            }

            while (fileAid != 3) {
            }
            synchronized (fileA) {
                fileWriter("fileA", str);
                fileAid = 4;
            }

            while (fileDid != 3) {

            }
            synchronized (fileD) {
                fileWriter("fileD", str);
                fileDid = 4;
            }

        }
    }

    private void fourthRun(String str) throws IOException, InterruptedException {
        start.await();
        while (true) {
            while (fileDid != 4) {

            }
            synchronized (fileD) {
                fileWriter("fileD", str);
                fileDid = 1;
            }

            while (fileCid != 4) {

            }
            synchronized (fileC) {
                fileWriter("fileC", str);
                fileCid = 1;
            }

            while (fileBid != 4) {

            }
            synchronized (fileB) {
                fileWriter("fileB", str);
                fileBid = 1;
            }

            while (fileAid != 4) {
            }
            synchronized (fileA) {
                fileWriter("fileA", str);
                fileAid = 1;
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
        ThreadOrderRun4 threadOrderRun4 = new ThreadOrderRun4();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threadOrderRun4.firstRun("1 ");
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
                    threadOrderRun4.secondRun("2 ");
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
                    threadOrderRun4.thirdRun("3 ");
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
                    threadOrderRun4.fourthRun("4 ");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        threadOrderRun4.start.countDown();
    }
}
