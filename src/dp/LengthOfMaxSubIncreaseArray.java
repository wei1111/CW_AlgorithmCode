package dp;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/10 0:41
 * @Description: 求最长公共子序列的长度，==前一个比他小的结尾的子序列+1
 * dp
 */
public class LengthOfMaxSubIncreaseArray {
    public int lengthOfMaxSubIncreaseArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int dp[] = new int[arr.length];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < arr.length; i++) {
            int max = Integer.MIN_VALUE;
            for (Integer integer : dp) {
                if (integer < arr[i]) {
                    max = Math.max(integer, max);
                }
            }
            dp[i] = max + 1;
            result = Math.max(dp[i], result);
        }
        return result;
    }

    @Test
    public void test() {
        int[] arr = {5, -6, 4, 2, 0, -1, 3, 5};
        int result = lengthOfMaxSubIncreaseArray(arr);
        System.out.println(result);
    }
}
