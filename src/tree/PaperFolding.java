package tree;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/22 13:48
 * @Description:
 */
public class PaperFolding {
    public static void printAllFolds(int N) {
        printProcess(1, N, true);
    }

    public static void printProcess(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        printProcess(i + 1, N, true);
        System.out.println(down ? "down" : "up");
        printProcess(i + 1, N, false);
    }

    @Test
    public void test() {
        printAllFolds(3);
    }
}
