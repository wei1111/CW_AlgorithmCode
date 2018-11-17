package sort;

import org.junit.Test;
import utils.SwapUtil;

import java.util.Arrays;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/17 15:23
 * @Description:
 */
public class NetherlandsFlag {
    public Integer[] partition(Integer[] nums, int l, int r, int p) {
        int less = l - 1;
        int more = r + 1;
        while (l < more) {
            if (nums[l] < p) {
                SwapUtil.swap(nums, ++less, l++);
            } else if (nums[l] > p) {
                //这里很重要，一定要记住从后往前的话，l是不用变得
                SwapUtil.swap(nums, --more, l);
            } else {
                l++;
            }
        }
        return new Integer[]{less + 1, more - 1};
    }


    @Test
    public void test() {
//        Integer[] testArr = VerificationUtil.generateRandomArray(10, 100);
        Integer[] testArr = new Integer[]{50};
        System.out.println(Arrays.toString(testArr));
        Integer[] partition = partition(testArr, 0, testArr.length - 1, 50);
        System.out.println(Arrays.toString(partition));

    }
}
