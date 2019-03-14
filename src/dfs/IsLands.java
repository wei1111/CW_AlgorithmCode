package dfs;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/23 13:26
 * @Description: 岛问题
 * 一个矩阵中只有0和1两种值， 每个位置都可以和自己的上、 下、 左、 右
 * 四个位置相连， 如果有一片1连在一起， 这个部分叫做一个岛， 求一个
 * 矩阵中有多少个岛？
 * 举例：
 * 0 0 1 0 1 0
 * 1 1 1 0 1 0
 * 1 0 0 1 0 0
 * 0 0 0 0 0 0
 * 这个矩阵中有三个岛。
 * 这个问题使用dfs可以很简单的解决，但是可以扩展为分布式的parallel计算
 * 使用并查集来合并相邻的集合
 */
public class IsLands {
    public int countIslands(int[][] m) {
        if (m == null || m[0] == null) {
            return 0;
        }
        int N = m.length;
        int M = m[0].length;
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (m[i][j] == 1) {
                    result++;
                }
                infect(m, i, j, N, M);
            }
        }
        return result;
    }

    //感染函数
    public void infect(int[][] m, int i, int j, int N, int M) {
        if (i >= 0 && i < N && j >= 0 && j < M && m[i][j] == 1) {
            m[i][j] = 2;
        } else {
            return;
        }

        infect(m, i - 1, j, N, M);
        infect(m, i + 1, j, N, M);
        infect(m, i, j - 1, N, M);
        infect(m, i, j + 1, N, M);
    }

    @Test
    public void test() {
        {
            int[][] m1 = {
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 1, 1, 1, 0, 1, 1, 1, 0},
                    {0, 1, 1, 1, 0, 0, 0, 1, 0},
                    {0, 1, 1, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 1, 1, 0, 0},
                    {0, 0, 0, 0, 1, 1, 1, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 1},};
            System.out.println(countIslands(m1));
            for (int i = 0; i < m1.length; i++) {
                System.out.println(Arrays.toString(m1[i]));
            }
            int[][] m2 = {
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 1, 1, 1, 1, 1, 1, 1, 0},
                    {0, 1, 1, 1, 0, 0, 0, 1, 0},
                    {0, 1, 1, 0, 0, 0, 1, 1, 0},
                    {0, 0, 0, 0, 0, 1, 1, 0, 0},
                    {0, 0, 0, 0, 1, 1, 1, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},};
            System.out.println(countIslands(m2));

        }
    }
}
