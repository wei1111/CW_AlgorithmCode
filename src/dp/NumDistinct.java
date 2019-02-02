package dp;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2019/1/28 17:02
 * @Description:
 */
public class NumDistinct {

    @Test
    public void test() {
        String s = "ddd";
        String t = "dd";
        int i = numDistinct(s, t);
        System.out.println(i);
    }

    public int numDistinct(String S, String T) {
        //不是最长公共子串问题，有点难想，还是记住吧
        char[] chss = S.toCharArray();
        char[] chst = T.toCharArray();
        int row = chss.length;
        int col = chst.length;
        int[] dp = new int[col + 1];
        dp[0] = 1;
        for (int i = 0; i < row; i++) {
            for (int j = col-1; j >=0; j--) {
                if (chss[i] == chst[j]) {
                    dp[j + 1] = dp[j + 1] + dp[j];
                }
            }
        }
        return dp[col];

        //int[][] dp = new int[row+1][col+1];
        //for(int i=0;i<row+1;i++){
        //    dp[i][0]=1;
        //}
        // 因为当前结果只取决于上一行结果的当前位置和后面一位，因此可以降维
        //for(int i=0;i<row;i++){
        //    for(int j=0;j<col;j++){
        //        if(chss[i]==chst[j]){
        //            dp[i+1][j+1] = dp[i][j+1]+dp[i][j];
        //        }else{
        //            dp[i+1][j+1] = dp[i][j+1];
        //        }
        //    }
        //}
        //return dp[row][col];
    }
}
