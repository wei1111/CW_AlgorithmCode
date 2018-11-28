package dp;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/27 18:48
 * @Description: 最长上升子序列问题
 * 给定一个无序的整数数组，找到其中最长上升子序列的长
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4
 */
public class LongestIncreasingSubsequence {
    public int longestIncreasingSubsequence(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = dp[0];

        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
            result = Math.max(dp[i], result);
        }
        return result;
    }

    @Test
    public void test() {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
//        int[] nums = new int[]{1, 2, 1, 2, 1, 2};
        int i = longestIncreasingSubsequence(nums);
        System.out.println(i);
    }
}
