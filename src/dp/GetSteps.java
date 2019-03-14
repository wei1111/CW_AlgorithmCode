package dp;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 19:38
 * @Description: 一个环上有10个点，编号为0-9，从0点出发，每步可以顺时针到下一个点，
 * 也可以逆时针到上一个点，求：经过n步又回到0点有多少种不同的走法
 * <p>
 * 如果n=1，则从0出发只能到1或者9，不可能回到0，共0种走法
 * 如果n=2，则从0出发有4条路径:0->1->2, 0->1->0, 0->9->8, 0->9->0,其中有两条回到了0点，故一共有2种走法
 * <p>
 * d(k, j)表示从点j 走k步到达原点0的方法数，因此可以转化为他相邻的点经过k-1步回到原点的问题，这样将
 * 问题的规模
 * <p>
 * 缩小.由于是环的问题， j-1, j+1可能会超出 0到n-1的范围，因此，我们将递推式改成如下：
 * d(k, j) = d(k-1, j-1) + d(k-1, j+1);
 * d(k, j) = d(k-1, (j-1+n)%n) + d(k-1, (j+1)%n);
 */
public class GetSteps {
    //n个点，k步
    public int getSteps(int n, int k) {
        if (n == 1) {
            //只有一个点怎么都行
            return 1;
        }
        if (n == 2) {
            //两个点的话就只有两种可能
            return k % 2 == 0 ? 1 : 0;
        }
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[(i - 1 + n) % n][j - 1] + dp[(i + 1) % n][j - 1];
            }
        }
        return dp[0][k];
    }

    @Test
    public void test() {
        int steps = getSteps(3, 3);
        System.out.println(steps);

    }
}
