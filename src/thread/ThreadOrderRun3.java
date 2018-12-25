package thread;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
 * 现在发现这个是有执行顺序的
 * 线程1： A -> D -> C -> B
 * 线程2： B -> A -> D -> C
 * 线程3： C -> B -> A -> D
 * 线程4： D -> C -> B -> A
 */
public class ThreadOrderRun3 {
    File fileA = new File("A.txt");
    File fileB = new File("B.txt");
    File fileC = new File("C.txt");
    File fileD = new File("D.txt");
    FileWriter fwA;
    FileWriter fwB;
    FileWriter fwC;
    FileWriter fwD;

    public ThreadOrderRun3() throws IOException {
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

            synchronized (fileA) {
                fileWriter("fileA", str);
            }
            Thread.sleep(50);

            synchronized (fileD) {
                fileWriter("fileD", str);
            }
            Thread.sleep(50);


            synchronized (fileC) {
                fileWriter("fileC", str);
            }
            Thread.sleep(50);

            synchronized (fileB) {
                fileWriter("fileB", str);
            }
            Thread.sleep(50);
        }

    }

    private void secondRun(String str) throws IOException, InterruptedException {
        while (true) {
            synchronized (fileB) {
                fileWriter("fileB", str);
            }
            Thread.sleep(50);
            synchronized (fileA) {
                fileWriter("fileA", str);
            }
            Thread.sleep(50);
            synchronized (fileD) {
                fileWriter("fileD", str);
            }
            Thread.sleep(50);

            synchronized (fileC) {
                fileWriter("fileC", str);
            }
            Thread.sleep(50);
        }
    }

    private void thirdRun(String str) throws IOException, InterruptedException {
        while (true) {
            synchronized (fileC) {
                fileWriter("fileC", str);
            }
            Thread.sleep(50);
            synchronized (fileB) {
                fileWriter("fileB", str);
            }

            Thread.sleep(50);
            synchronized (fileA) {
                fileWriter("fileA", str);
            }
            Thread.sleep(50);
            synchronized (fileD) {
                fileWriter("fileD", str);
            }
            Thread.sleep(50);
        }
    }

    private void fourthRun(String str) throws IOException, InterruptedException {
        while (true) {
            synchronized (fileD) {
                fileWriter("fileD", str);
            }
            Thread.sleep(50);
            synchronized (fileC) {
                fileWriter("fileC", str);
            }
            Thread.sleep(50);
            synchronized (fileB) {
                fileWriter("fileB", str);
            }
            Thread.sleep(50);
            synchronized (fileA) {
                fileWriter("fileA", str);
            }
            Thread.sleep(50);
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
        ThreadOrderRun3 threadOrderRun3 = new ThreadOrderRun3();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threadOrderRun3.firstRun("1 ");
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
                    threadOrderRun3.secondRun("2 ");
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
                    threadOrderRun3.thirdRun("3 ");
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
                    threadOrderRun3.fourthRun("4 ");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
