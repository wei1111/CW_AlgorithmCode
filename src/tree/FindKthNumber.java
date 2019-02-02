package tree;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2019/1/31 19:04
 * @Description:
 */
public class FindKthNumber {

    @Test
    public void test() {
        for (int i = 1; i <= 10; i++) {
            int kthNumber = findKthNumber(100, i);
            System.out.println(kthNumber);
        }
    }

    public int findKthNumber(int n, int k) {
        int cur = 1;
        int step;
        k--;
        while (k > 0) {
            step = calStep(n, cur, cur + 1);
            if (step <= k) {
                k -= step;
                cur++;
            } else {
                k--;
                cur *= 10;
            }
        }
        return cur;
    }

    private int calStep(int n, long n1, long n2) {
        int step = 0;
        while (n1 <= n) {
            step += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return step;
    }
}
