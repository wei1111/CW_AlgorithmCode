package dp;

import org.junit.Test;

public class NumWays {
    /**
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     * <p>
     * 514.栅栏染色
     * 我们有一个栅栏，它有n个柱子，现在要给柱子染色，有k种颜色可以染。
     * 必须保证不存在超过2个相邻的柱子颜色相同，求有多少种染色方案。
     * <p>
     * 样例
     * n = 3, k = 2, return 6
     * <p>
     * post 1,   post 2, post 3
     * way1    0         0       1
     * way2    0         1       0
     * way3    0         1       1
     * way4    1         0       0
     * way5    1         0       1
     */
    //递归大数字n会超出memory
    public int numWays1(int n, int k) {
        // write your code here
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return k;
        } else if (n == 2) {
            return k * k;
        } else {
            return (numWays1(n - 2, k) + numWays1(n - 1, k)) * (k - 1);
        }
        /**
         * 0 0
         * 1 2
         * 2 4
         * 3 6
         */

    }

    public int numWays2(int n, int k) {
        // write your code here
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return k;
        } else if (n == 2) {
            return k * k;
        }
        int n1 = k;
        int n2 = k * k;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = (n1 + n2) * (k - 1);
            n1 = n2;
            n2 = temp;
        }
        return temp;
    }

    @Test
    public void testNumWays() {
        System.out.println(numWays1(3, 2));
    }
}
