package dp;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/10 15:44
 * @Description: 最大公共子串
 * c[i][j]=0;                           i=0||j==0
 * c[i][j]=c[i-1][j-1]+1                i>0&&j>0&&xi==yj
 * c[i][j]=0                            i>0&&j>0&&xi!=yj
 */
public class LongestCommonSubstring {
    public int longestCommonSubstring(char[] arr1, char[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0) {
            return 0;
        }
        int[][] dp = new int[arr1.length + 1][arr2.length + 1];
        int max = 0;
        for (int i = 1; i < arr1.length + 1; i++) {
            for (int j = 1; j < arr2.length + 1; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(dp[i][j], max);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }

    @Test
    public void test() {
        String s1 = "ABCBDAB";
        String s2 = "BDCABCBD";
        System.out.println(longestCommonSubstring(s1.toCharArray(), s2.toCharArray()));
    }
}
