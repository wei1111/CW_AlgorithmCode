package sort;

import org.junit.Test;
import utils.VerificationUtil;

import java.util.Arrays;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/28 18:00
 * @Description: 求一组数中最大的间隔
 */
public class MaxGap {
    public int maxGap(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
        }

        //经过这样的设计第一个和最后一个的桶中一定会有数据
        boolean[] hasNum = new boolean[arr.length + 1];
        int[] maxs = new int[arr.length + 1];
        int[] mins = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            //这与这里时arr.length 毕竟时从0开始 的
            int bucket = getBucket(arr[i], arr.length, max, min);
            if (bucket >= arr.length + 1) {
                System.out.println(arr.length + 1);
                System.out.println(bucket);
            }
            maxs[bucket] = hasNum[bucket] ? Math.max(maxs[bucket], arr[i]) : arr[i];
            mins[bucket] = hasNum[bucket] ? Math.min(mins[bucket], arr[i]) : arr[i];
            hasNum[bucket] = true;
        }
        int result = Integer.MIN_VALUE;
        int lastMax = maxs[0];
        for (int i = 1; i < arr.length + 1; i++) {
            if (hasNum[i]) {
                result = Math.max(mins[i] - lastMax, result);
                lastMax = maxs[i];
            }
        }
        return result;
    }

    private int getBucket(int i, int length, int max, int min) {
        return (int) ((i - min) * length / (max - min));
//        return (int) ((num - min) * len / (max - min));
    }

    // for test
    public int comparator(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(nums[i] - nums[i - 1], gap);
        }
        return gap;
    }

    @Test
    public void test() throws Exception {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
            int[] randomIntArray = VerificationUtil.getRandomIntArray(30, -100, 1000);
            if (comparator(randomIntArray) != maxGap(randomIntArray)) {
                System.out.println("shit");
            } else {
                System.out.println(comparator(randomIntArray) + " == " + maxGap(randomIntArray));
            }
        }
    }
}
