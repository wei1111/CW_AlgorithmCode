package number;

import org.junit.Test;

public class BinarySearch {
    /**
     * @param : The integer array.
     * @param : Target to find.
     * @return: The first position of target. Position starts from 0.
     * <p>
     * 二分查找
     * 给定一个排序的整数数组（升序）和一个要查找的整数target，用O(logn)的时间查找到target第一次出现的下标（从0开始），如果target不存在于数组中，返回-1。
     * <p>
     * 样例
     * 在数组 [1, 2, 3, 3, 4, 5, 10] 中二分查找3，返回2。
     * <p>
     * 挑战
     * 如果数组中的整数个数超过了2^32，你的算法是否会出错？
     */

    @Test
    public void testBinarySearch() {
        int[] nums = new int[]{1};
        System.out.println(binSearch(nums, 0, nums.length - 1, 1));
    }

    public int binSearch(int[] nums, int low, int high, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int mid;
        while (low <= high) {
            mid = low + (high - low) >> 1;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
//    public int binSearch(int[] nums, int f, int l, int target) {
//        if (f > l) {
//            return -1;
//        }
//        if (nums[(l + f) / 2] == target) {
//            return (l + f) / 2;
//        } else if (nums[(l + f) / 2] < target) {
//            return binSearch(nums, (l + f) / 2 + 1, l, target);
//        } else {
//            return binSearch(nums, f, (l + f) / 2 - 1, target);
//        }
//    }
}
