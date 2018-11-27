package dp;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/24 1:17
 * @Description:
 */
public class MinPath {
    public int minPath1(int[][] matrix) {
        return recursion1(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    private int recursion1(int[][] matrix, int i, int j, int y, int x) {
        int min = matrix[i][j];
        if (i == y && j == x) {
            return min;
        }
        if (i == y && j < x) {
            return min + recursion1(matrix, i, j + 1, y, x);
        }
        if (i < y && j == x) {
            return min + recursion1(matrix, i + 1, j, y, x);
        }
        int m1 = recursion1(matrix, i, j + 1, y, x);
        int m2 = recursion1(matrix, i + 1, j, y, x);
        return min + Math.min(m1, m2);
    }

    @Test
    public void test() {
        int[][] m = {
                {1, 3, 5, 9},
                {8, 1, 3, 4},
                {5, 0, 6, 1},
                {8, 8, 4, 0}
        };
        System.out.println(minPath1(m));

        String str1 = "chenweni";
        String str2 = "en";
        System.out.println(str1.indexOf(str2));
    }
}
