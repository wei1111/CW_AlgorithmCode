package dp;

import utils.VerificationUtil;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/27 19:25
 * @Description: 背包问题
 * 给定两个数组w和v， 两个数组长度相等， w[i]表示第i件商品的
 * 重量， v[i]表示第i件商品的价值。 再给定一个整数bag， 要求
 * 你挑选商品的重量加起来一定不能超 过bag， 返回满足这个条件
 * 下， 你能获得的最大价值。
 * <p>
 * 情况一: 第i件不放进去，这时所得价值为:f[i-1][v]
 * 情况二: 第i件放进去，这时所得价值为：f[i-1][v-c[i]]+w[i]
 * 状态转移方程为：f[i][v] = max(f[i-1][v], f[i-1][v-w[i]]+c[i])
 * <p>
 * 思路：申请一个大小为N*W的矩阵dp，dp[i][j]表示当重量不超过j时前i件物品的最大值，他有两种情况：
 * 1. 第i件物品确定装入背包，那么前i-1个物品的重量不能超过j-w[i]，此时dp[i][j]=dp[i-1][j-w[i]+v[i]
 * 2. 第i件物品不装入背包，那么前i-1个物品的重量不超过j即可，此时dp[i][j]=dp[i-1][j]
 * dp[i][j]就取二者中的最大值即可
 */
public class Knapsack {

    public static int maxValue1(int[] c, int[] p, int bag) {
        int[] al = new int[c.length];
        return process1(c, p, 0, al, bag);
    }

    public static int process1(int[] weights, int[] values, int i, int[] alreadyweight, int bag) {
        if (i == weights.length) {
            return 0;
        }

        if (i > 0) {
            alreadyweight[i] = alreadyweight[i - 1];
        }
        int v1 = process1(weights, values, i + 1, alreadyweight, bag);

        alreadyweight[i] += weights[i];
        int v2 = 0;
        if (alreadyweight[i] > bag) {
            return Math.max(v1, v2);
        } else {
            v2 = values[i] + process1(weights, values, i + 1, alreadyweight,
                    bag);
        }
        alreadyweight[i] -= weights[i];
        return Math.max(v1, v2);
    }


//    public static int maxValue2(int[] c, int[] p, int bag) {
//
//
//    }


    public static int maxValue2(int[] c, int[] p, int bag) {
        int[][] dp = new int[c.length + 1][bag + 1];
        for (int i = c.length - 1; i >= 0; i--) {
            for (int j = bag; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + c[i] <= bag) {
                    dp[i][j] = Math.max(dp[i][j], p[i] + dp[i + 1][j + c[i]]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        //25
        for (int i = 0; i < 1000; i++) {
            int[] c = VerificationUtil.getLenRandomIntArray(100, 100);
            int[] p = VerificationUtil.getLenRandomIntArray(100, 100);
            int bag = (int) Math.random() * 1000;

            System.out.println(maxValue1(c, p, bag));
            System.out.println(maxValue2(c, p, bag));
            System.out.println("-------------------------------");
        }

        int[] c = { 3, 2, 4, 7 };
        int[] p = { 5, 6, 3, 19 };
        int bag = 11;
        System.out.println(maxValue1(c, p, bag));
    }
}
