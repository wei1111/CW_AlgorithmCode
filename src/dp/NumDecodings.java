package dp;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2019/1/28 15:33
 * @Description:
 */
public class NumDecodings {
    @Test
    public void test() {
        int i = numDecodings("17");
        System.out.println(i);
    }

    public int numDecodings(String s) {
        //简单的动态规划，可是我是看的答案。。
        // dp[i]表示s[0~i-1]可以有多少种解码方式
        // 递推方程：如果1 <= s[i-1] <= 9，则dp[i] += dp[i-1]；
        // 如果10 <= s[i-2 ~ i-1] <= 26, 则dp[i] += dp[i-2].
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        if (len == 1) {
            return (s.charAt(0) - '0') == 0 ? 0 : 1;
        }
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;//只有一个字母的情况
        for (int i = 2; i < len + 1; i++) {
            int i1 = s.charAt(i - 1) - '0';
            int i2 = s.charAt(i - 2) - '0';
            if (i1 <= 9 && i1 >= 1) {
                dp[i] += dp[i - 1];
            }
            if (i2 >= 1 && i2 <= 2) {
                if (i2 == 2 && (i1 > 6)) {
                    continue;
                }
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }
}
