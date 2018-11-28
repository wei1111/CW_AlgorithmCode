package recursion;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/27 13:38
 * @Description:
 */
public class Hanoi {
    public void hanoi(int n) {
        recur(0, n, "左", "中", "右");
    }

    private void recur(int i, int n, String left, String median, String right) {
        if (n == 1) {
            System.out.println("第 " + i + " 个从 " + left + " 到 " + right);
        } else {
            //这个实在是太难了，记住算了
            recur(n - 1, n - 1, left, right, median);
            recur(n, 1, left, median, right);
            recur(n - 1, n - 1, median, left, right);
        }
    }

    @Test
    public void test() {
        hanoi(3);
    }
}
