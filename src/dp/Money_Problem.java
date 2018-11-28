package dp;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/27 16:40
 * @Description: dp
 * 给你一个数组arr， 和一个整数aim。 如果可以任意选择arr中的
 * 数字， 能不能累加得到aim， 返回true或者false
 */
public class Money_Problem {
    public boolean money1(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return process1(arr, 0, 0, aim);
    }

    //用子序列来2^n

    private boolean process1(int[] arr, int i, int sum, int aim) {
        if (sum == aim) {
            return true;
        }
        if (i == arr.length) {
            return false;
        }

        //先写出不是dp的代码，根据这个代码的下一行逻辑生成dp[][]数组★★★★★
        return process1(arr, i + 1, sum, aim) || process1(arr, i + 1, sum + arr[i], aim);
    }

    public boolean money2(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return process2(arr,  aim);
    }

    private boolean process2(int[] arr, int aim) {
        int row = arr.length + 1;
        int col = aim + 1;
        //java中数组默认初始化为false
        boolean[][] dp = new boolean[row][col];
        for (int j = 0; j < row; j++) {
            dp[j][col-1] = true;
        }

//      process1(arr, i + 1, sum, aim) || process1(arr, i + 1, sum + arr[i], aim);
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                //理解这里的j就是sum
                if (j + arr[i] <= aim) {
                    dp[i][j] = dp[i][j] || dp[i + 1][j + arr[i]];
                }
            }
        }
        return dp[0][0];
    }

    @Test
    public void test() {
        int[] arr = {1, 4, 9};
        int aim = 9;
        System.out.println(money1(arr, aim));
        System.out.println(money2(arr, aim));
    }
}
