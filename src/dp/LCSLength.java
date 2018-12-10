package dp;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/10 15:21
 * @Description: 最长公共子序列
 * 问题描述：字符序列的子序列是指从给定字符序列中随意地（不一定连续）去掉若干个字符（可能一个也不去掉）后所形成的字符序列。令给定的字符序列X=“x0，x1，…，xm-1”，序列Y=“y0，y1，…，yk-1”是X的子序列，存在X的一个严格递增下标序列<i0，i1，…，ik-1>，使得对所有的j=0，1，…，k-1，有xij=yj。例如，X=“ABCBDAB”，Y=“BCDB”是X的一个子序列。
 * <p>
 * 考虑最长公共子序列问题如何分解成子问题，设A=“a0，a1，…，am-1”，B=“b0，b1，…，bn-1”，并Z=“z0，z1，…，zk-1”为它们的最长公共子序列。不难证明有以下性质：
 * <p>
 * （1） 如果am-1=bn-1，则zk-1=am-1=bn-1，且“z0，z1，…，zk-2”是“a0，a1，…，am-2”和“b0，b1，…，bn-2”的一个最长公共子序列；
 * <p>
 * （2） 如果am-1!=bn-1，则若zk-1!=am-1，蕴涵“z0，z1，…，zk-1”是“a0，a1，…，am-2”和“b0，b1，…，bn-1”的一个最长公共子序列；
 * <p>
 * （3） 如果am-1!=bn-1，则若zk-1!=bn-1，蕴涵“z0，z1，…，zk-1”是“a0，a1，…，am-1”和“b0，b1，…，bn-2”的一个最长公共子序列。
 * <p>
 * 原文：https://blog.csdn.net/wangdd_199326/article/details/76464333
 * <p>
 * c[i][j]=0;                           i=0||j==0
 * c[i][j]=c[i-1][j-1]+1                i>0&&j>0&&xi==yj
 * c[i][j]=max(c[i][j-1],c[i-1][j])     i>0&&j>0&&xi!=yj
 */
public class LCSLength {
    public int lCSLength(char[] arr1, char[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0) {
            return 0;
        }
        int[][] dp = new int[arr1.length + 1][arr2.length + 1];
        for (int i = 1; i < arr1.length + 1; i++) {
            for (int j = 1; j < arr2.length + 1; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[arr1.length][arr2.length];
    }

    @Test
    public void test() {
        String s1 = "ABCBDAB";
        String s2 = "BDCABCD";
        System.out.println(lCSLength(s1.toCharArray(), s2.toCharArray()));
    }
}
