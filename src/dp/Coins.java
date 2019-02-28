package dp;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 0:49
 * @Description: 背包 选钱
 */
public class Coins {
    int len = 0;

    public int coins(int[] arr, int sum) {

        dfs(arr, sum, 0, 0, new LinkedList<Integer>());
        return len;
    }

    private void dfs(int[] arr, int sum, int i, int temp, LinkedList<Integer> list) {
        if (temp == sum) {
            len++;
            System.out.println(list);
        }
        if (temp > sum) {
//            list.remove(list.size() - 1);
            return;
        }
        for (int j = i; j < arr.length; j++) {
            list.add(arr[j]);
            dfs(arr, sum, j, temp + arr[j], list);
            list.remove(list.size() - 1);
        }
    }

    @Test
    public void test() {
        int[] arr = new int[]{1, 2, 5, 10};
        int coins = coins(arr, 200);
        int coins2 = coins2(arr, 200);
        System.out.println(coins);
        System.out.println();
        System.out.println(coins2);
    }


    public int coins2(int[] arr, int sum) {
        int row = arr.length + 1;
        int dp[][] = new int[row][sum + 1];
        dp[row - 1][0] = 1;
        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j < sum + 1; j++) {
                for (int k = j; k >= 0; k -= arr[i]) {
                    dp[i][j] += dp[i + 1][k];
                }
            }
        }
        return dp[0][sum];
    }
}
