package number;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/24 12:49
 * @Description:
 */
public class MoreThanHalfNum_Solution {
    //这题的解法很巧妙
    public int moreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int sum = 1;
        int num = array[0];
        for (int x = 1; x < array.length; x++) {
            if (array[x] == num) {
                sum++;
            } else {
                sum--;
                if (sum == 0) {
                    num = array[x];
                    sum = 1;
                }
            }
        }
        if (sum > 1) {
            return num;
        } else if (sum == 1) {
            int time = 0;
            for (int x = 0; x < array.length; x++) {
                if (array[x] == num) {
                    time++;
                }
            }
            if (time > array.length / 2) {
                return num;
            }
            return 0;
        } else {
            return 0;
        }
    }

    @Test
    public void test() {
        int[] arr = {2, 2, 2, 2, 2, 1, 3, 4, 5};
        System.out.println(moreThanHalfNum_Solution(arr));
    }
}
