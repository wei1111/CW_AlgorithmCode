package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/16 22:57
 * @Description: 小和问题，一个数左边比他小的数的合为这个数的小和，求一个数组的小和 [1, 3, 4, 2, 5] 16
 * 小和问题是一个merge的问题,小和问题是乘
 * 逆序对为题是加
 */
public class SmallSum {
    public int smallSum(Integer[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Integer[] temp = new Integer[nums.length];
        return mergeSort(nums, 0, nums.length - 1, temp);
    }

    private int mergeSort(Integer[] nums, int start, int end, Integer[] temp) {
        int mid = start + ((end - start) >> 1);
        if (start == end) {
            return 0;
        }

        int r1 = mergeSort(nums, start, mid, temp);
        int r2 = mergeSort(nums, mid + 1, end, temp);
        int r3 = merge(nums, start, mid, end, temp);
        return r1 + r2 + r3;
    }

    private int merge(Integer[] nums, int start, int mid, int end, Integer[] temp) {
        int x1 = start;
        int x2 = mid + 1;
        int t = 0;
        int result = 0;
        while (x1 <= mid && x2 <= end) {
            //这里有没有<= 也很重要，有了就是求<=的和了
            if (nums[x1] < nums[x2]) {
                //在这里求小和
                result += (end - x2 + 1) * nums[x1];
                temp[t++] = nums[x1++];
            } else {
                temp[t++] = nums[x2++];
            }
        }
        while (x1 <= mid) {
            temp[t++] = nums[x1++];
        }
        while (x2 <= end) {
            temp[t++] = nums[x2++];
        }
        t = 0;
        while (start <= end) {
            nums[start++] = temp[t++];
        }
        return result;
    }

    @Test
    public void testMergeSortedArray() {
        // 20
        Integer[] B = {1, 1, 3, 4, 2, 5};
        System.out.println("B" + Arrays.toString(B));
        int i = smallSum(B);
        System.out.println("B" + Arrays.toString(B));
        System.out.println("result:" + i);
        int mid = 1 + ((3 - 1) >> 1);
        int mid1 = 1 + (3 - 1) >> 1;
        System.out.println(mid);
        System.out.println(mid1);

        double d = 1.9;
        System.out.println((int)d);
    }
}
