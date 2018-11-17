package sort;

import org.junit.Test;
import utils.SwapUtil;

import java.util.Arrays;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/16 20:27
 * @Description:
 */
public class SelectionSort {
    public void selectionSort(Integer[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int length = nums.length;
        for (int i = 0; i < length-1; i++) {
            int min = i;
            //这里注意 j = i + 1
            for (int j = i+1; j < length; j++) {
                min = nums[min] > nums[j] ? j : min;
            }
            SwapUtil.swap(nums, min, i);
        }
    }

    @Test
    public void test() {
        Integer[] nums = {1, 1, 1, 1, 23, 2334, 2, 2, 34, 2342, 7, 9, 3, 4, 5, 10, 8};
        System.out.println(Arrays.toString(nums));
        selectionSort(nums);
        System.out.println("sort: " + Arrays.toString(nums));
    }
}
