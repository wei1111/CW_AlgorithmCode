package sort;

import org.junit.Test;
import utils.SwapUtil;

import java.util.Arrays;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/16 20:46
 * @Description:
 */
public class InsertionSort {
    public void insertionSort(Integer[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int length = nums.length;
        //有点像大牌
        for (int i = 1; i < length - 1; i++) {
            for (int j = i - 1; j >= 0 && nums[j] > nums[j - 1]; j--) {
                SwapUtil.swap(nums, j, j + 1);
            }
        }
    }

    @Test
    public void test() {
        Integer[] nums = {1, 1, 1, 1, 23, 2334, 2, 2, 34, 2342, 7, 9, 3, 4, 5, 10, 8};
        System.out.println(Arrays.toString(nums));
        insertionSort(nums);
        System.out.println("sort: " + Arrays.toString(nums));
    }
}
