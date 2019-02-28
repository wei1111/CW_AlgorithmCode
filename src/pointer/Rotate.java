package pointer;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/18 18:36
 * @Description:
 */
public class Rotate {
    @Test
    public void test() {
        int[][] nums = {{1, 2}, {3, 4}};
        rotate(nums);
    }

    public void rotate(int[][] matrix) {
        //顺时针旋转90度的意思
        if (matrix == null || matrix.length == 0 || matrix[0].length != matrix.length) {
            return;
        }
        int m = 0;
        int n = matrix.length - 1;

        while (n >= m) {
            int x1 = m;
            int y1 = m;

            int x2 = m;
            int y2 = n;

            int x3 = n;
            int y3 = n;

            int x4 = n;
            int y4 = m;
            while (y1 < n) {
                int temp = matrix[x1][y1];
                matrix[x1][y1] = matrix[x2][y2];
                matrix[x2][y2] = matrix[x3][y3];
                matrix[x3][y3] = matrix[x4][y4];
                matrix[x4][y4] = temp;
                y1++;
                x2++;
                y3--;
                x4--;
            }
            m++;
            n--;
        }
    }
}
