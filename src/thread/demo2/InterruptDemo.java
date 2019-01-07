package thread.demo2;

/**
 * @Author: wei1
 * @Date: Create in 2019/1/1 10:41
 * @Description:
 */
public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        WriterReader writerReader = new WriterReader();
        Thread writer = new Thread(new Runnable() {
            @Override
            public void run() {
                writerReader.write();
            }
        });
        writer.start();

        Thread reader = new Thread(new Runnable() {
            @Override
            public void run() {
                writerReader.read();
            }
        });
        reader.start();


        Thread.sleep(10);
//        writer.interrupt();
        reader.interrupt();
        System.out.println("reader.isInterrupted():" + reader.isInterrupted());
        Thread.sleep(10000);
        System.out.println("reader.isInterrupted():" + reader.isInterrupted());
        writer.interrupt();
    }
}
