package number;

import org.junit.Test;
import utils.VerificationUtil;

import java.util.Arrays;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/17 20:29
 * @Description: 给定一个数组， 求如果排序之后， 相邻两数的最大差值， 要求时
 * 间复杂度O(N)， 且要求不能用非基于比较的排序。
 * <p>
 * 这个题目不让使用基数排序，但是可以使用他的思路来用
 * n个数给n+1个桶，使用那个空桶来确认最大的差值一定不是来自桶的内部
 */
public class MaxGap {
    public int maxGap(Integer[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int length = nums.length;
        Integer min = Integer.MAX_VALUE;
        Integer max = Integer.MIN_VALUE;

        for (int i = 0; i < length; i++) {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }

        // 切记
        if (min.equals(max)) {
            return 0;
        }

        System.out.println(min + " " + max);

        boolean[] hasNum = new boolean[length + 1];
        Integer[] maxs = new Integer[length + 1];
        Arrays.fill(maxs, Integer.MIN_VALUE);
        Integer[] mins = new Integer[length + 1];
        Arrays.fill(mins, Integer.MAX_VALUE);

        for (int i = 0; i < length; i++) {
            int b = whichBucket(nums[i], min, max, length);
            hasNum[b] = true;
            maxs[b] = Math.max(maxs[b], nums[i]);
            mins[b] = Math.min(mins[b], nums[i]);
        }

        Integer resule = Integer.MIN_VALUE;
        //这里记录每个max很好，因为前面的放到桶的设计是一定在第一个桶和最后一个桶有值，所以可以直接取maxs[0]
        Integer lastMax = maxs[0];
        for (int i = 1; i < length + 1; i++) {
            if (hasNum[i]) {
                resule = Math.max(resule, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return resule;
    }

    private int whichBucket(Integer num, Integer min, Integer max, int length) {
        return (int) (num - min) * length / (max - min);
    }

    @Test
    public void test() {
        Integer[] arr = VerificationUtil.generateRandomArray(5, 99);
        System.out.println(Arrays.toString(arr));
        int result = maxGap(arr);
        System.out.println(result);
    }
}
