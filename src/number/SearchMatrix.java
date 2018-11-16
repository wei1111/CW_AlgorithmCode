package number;

import org.junit.Test;

import java.util.Arrays;

public class SearchMatrix {
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     * <p>
     * 28. 搜索二维矩阵
     * 写出一个高效的算法来搜索 m × n矩阵中的值。
     * <p>
     * 这个矩阵具有以下特性：
     * <p>
     * 每行中的整数从左到右是排序的。
     * 每行的第一个数大于上一行的最后一个整数。
     * 样例
     * 考虑下列矩阵：
     * <p>
     * [
     * [1, 3, 5, 7],
     * [10, 11, 16, 20],
     * [23, 30, 34, 50]
     * ]
     * 给出 target = 3，返回 true
     * <p>
     * 挑战
     * O(log(n) + log(m)) 时间复杂度
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        int i = 0;
        for (; i < matrix.length; i++) {
            if (matrix[i][0] == target) {
                return true;
            } else if (matrix[i][0] > target) {
                break;
            }
        }
        if (i == 0) {
            return false;
        }
        int result = Arrays.binarySearch(matrix[i - 1], target);
        if (result >= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void testSearchMatrix() {
        int[][] testArray = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(searchMatrix(testArray, 7));
    }
}
