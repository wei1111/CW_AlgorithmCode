package number;

import org.junit.Test;

import java.util.PriorityQueue;

public class NthUglyNumber {
    /**
     * @param n: An integer
     * @return: the nth prime number as description.
     * 答案来源：https://blog.csdn.net/htt789/article/details/79992923
     */

    /**
     * 丑数 II
     * 设计一个算法，找出只含素因子2，3，5 的第 n 小的数。
     * <p>
     * 符合条件的数如：1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
     * <p>
     * 样例
     * 如果n = 9， 返回 10
     * <p>
     * 挑战
     * 要求时间复杂度为O(nlogn)或者O(n)
     * <p>
     * 1
     * 2 3 5  2         2
     * 4 3 5  3         3
     * 6 4 5  4         2
     * 8 6 5  5         5
     * 10 8 6  6        3
     * 12 10 8 8        4
     */
    public int nthUglyNumber(int n) {
        // write your code here
        if (n == 1) {
            return 1;
        } else {
            int uglyNums[] = new int[n];
            uglyNums[0] = 1;
            int p5 = 0, p2 = 0, p3 = 0;
            for (int i = 1; i < n; i++) {
                uglyNums[i] = Math.min(Math.min(uglyNums[p2] * 2, uglyNums[p3] * 3),
                        Math.min(uglyNums[p2] * 2, uglyNums[p5] * 5));
                if (uglyNums[i] == uglyNums[p2] * 2) {
                    p2++;
                }
                if (uglyNums[i] == uglyNums[p3] * 3) {
                    p3++;
                }
                if (uglyNums[i] == uglyNums[p5] * 5) {
                    p5++;
                }
            }
            return uglyNums[n - 1];
        }
    }

    public int nthUglyNumber2(int n) {
        // write your code here
        int uglyNums[] = new int[n];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(n);
        priorityQueue.peek();
        priorityQueue.poll();
        return uglyNums[n - 1];
    }

    @Test
    public void testNthUglyNumber() {
        System.out.println(nthUglyNumber(9));
    }
}
