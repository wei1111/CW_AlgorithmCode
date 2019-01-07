package thread.demo2;

/**
 * @Author: wei1
 * @Date: Create in 2019/1/1 10:50
 * @Description:
 */
public class WriterReader {
    private Object lock;

    public WriterReader() {
        lock = this;
    }

    public void write() {
        synchronized (lock) {
            long startTime = System.currentTimeMillis();
            System.out.println("开始往这个buff写入数据…");
            for (; ; )// 模拟要处理很长时间
            {
                if (System.currentTimeMillis()
                        - startTime > Integer.MAX_VALUE) {
                    System.out.println("终于写完了");
                    break;
                }
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("被中断");
                    System.out.println(Thread.interrupted());
                    System.out.println(Thread.interrupted());
                    System.out.println(Thread.interrupted());
                    break;
                }
                System.out.println("写.........");
            }
        }
    }

    public void read() {
        synchronized (lock) {
            System.out.println("从这个buff读数据");
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("read被中断");
            }
        }
    }
}
