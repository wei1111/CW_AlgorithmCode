package jianzhioffer;

import java.util.ArrayList;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 15:38
 * @Description: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依
 * 次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int x1 = 0;
        int y1 = 0;
        int x2 = matrix.length - 1;
        int y2 = matrix[0].length - 1;
        while (x1 <= x2 && y1 <= y2) {
            printMatrix(x1++, y1++, x2--, y2--, matrix, result);
        }
        return result;
    }

    private void printMatrix(int x1, int y1, int x2, int y2, int[][] matrix,
                             ArrayList<Integer> result) {
        if (x1 == x2) {
            for (int i = y1; i <= y2; i++) {
                result.add(matrix[x1][i]);
            }
            return;
        }
        if (y1 == y2) {
            for (int i = x1; i <= x2; i++) {
                result.add(matrix[i][y1]);
            }
            return;
        }
        int y = y1;
        while (y <= y2) {
            result.add(matrix[x1][y++]);
        }
        int x = x1 + 1;
        while (x <= x2) {
            result.add(matrix[x++][y2]);
        }
        y = y2 - 1;
        while (y >= y1) {
            result.add(matrix[x2][y--]);
        }
        x = x2 - 1;
        while (x > x1) {
            result.add(matrix[x--][y1]);
        }
    }
}
