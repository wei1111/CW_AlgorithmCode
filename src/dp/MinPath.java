package dp;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/24 1:17
 * @Description: 这是一个典型的dp问题，求的dp[][]数组就ok了
 * 给你一个数组arr， 和一个整数aim。 如果可以任意选择arr中的
 * 数字， 能不能累加得到aim， 返回true或者false
 */
public class MinPath {
    public int minPath1(int[][] matrix) {
        return recursion1(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    private int recursion1(int[][] matrix, int i, int j, int y, int x) {
        int min = matrix[i][j];
        if (i == y && j == x) {
            return min;
        }
        if (i == y && j < x) {
            return min + recursion1(matrix, i, j + 1, y, x);
        }
        if (i < y && j == x) {
            return min + recursion1(matrix, i + 1, j, y, x);
        }
        int m1 = recursion1(matrix, i, j + 1, y, x);
        int m2 = recursion1(matrix, i + 1, j, y, x);
        return min + Math.min(m1, m2);
    }

    public int minPath2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        dp[row - 1][col - 1] = matrix[row - 1][col - 1];
        for (int i = col - 1; i > 0; i--) {
            dp[row - 1][i - 1] = matrix[row - 1][i - 1] + dp[row - 1][i];
        }
        for (int i = row - 1; i > 0; i--) {
            dp[i - 1][col - 1] = matrix[i - 1][col - 1] + dp[i][col - 1];
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }

    @Test
    public void test() {
        int[][] m = {
                {1, 3, 5, 9},
                {8, 1, 3, 4},
                {8, 1, 3, 4},
                {5, 0, 6, 1},
                {5, 0, 6, 1},
                {5, 0, 6, 1},
                {8, 8, 4, 0}
        };
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));

    }
}
