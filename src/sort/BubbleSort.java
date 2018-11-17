package sort;

import org.junit.Test;
import utils.SwapUtil;

import java.util.Arrays;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/16 20:18
 * @Description: 稳定
 */
public class BubbleSort {
    public void bubbleSort(Integer[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    SwapUtil.swap(nums, j, j + 1);
                }
            }
        }
    }

    @Test
    public void test() {
        Integer[] nums = {1, 1, 1, 1, 23, 2334, 2, 2, 34, 2342, 7, 9, 3, 4, 5, 10, 8};
        System.out.println(Arrays.toString(nums));
        bubbleSort(nums);
        System.out.println("sort: " + Arrays.toString(nums));
    }
}
