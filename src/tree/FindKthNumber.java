package tree;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: wei1
 * @Date: Create in 2019/1/31 19:04
 * @Description: 字典序第k小的数字
 */
public class FindKthNumber {

    @Test
    public void test() {
        for (int i = 1; i <= 10; i++) {
            int kthNumber = findKthNumber(100, i);
            System.out.println(kthNumber);
        }
    }
//    http://www.cnblogs.com/grandyang/p/6031787.html
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

    //字典排序数字1-n
    public int[] lexicalOrder(int n) {
        int[] res = new int[n];
        int cur = 1;
        for (int i = 0; i < n; ++i) {
            res[i] = cur;
            if (cur * 10 <= n) {
                cur *= 10;
            } else {
                if (cur >= n) {
                    cur /= 10;
                }
                cur += 1;
                while (cur % 10 == 0) {
                    cur /= 10;
                }
            }
        }
        return res;
    }

    @Test
    public void test2() {
        int[] ints = lexicalOrder(30);
        System.out.println(Arrays.toString(ints));
    }
}
