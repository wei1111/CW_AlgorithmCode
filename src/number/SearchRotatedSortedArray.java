package number;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/20 15:50
 * @Description: O(log n).二分的变形
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchRotatedSortedArray {
    public int searchRotatedSortedArray(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int index = searchIndex(nums);
        if (index == -1) {
            return binSearch(nums, 0, nums.length - 1, target);
        } else if (binSearch(nums, 0, index, target) != -1) {
            return binSearch(nums, 0, index, target);
        } else {
            return binSearch(nums, index + 1, nums.length - 1, target);
        }
    }

    private int searchIndex(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (mid + 1 <= high && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] < nums[low]) {
                high = mid;
            } else if (nums[mid] > nums[high]) {
                low = mid;
            } else {
                return -1;
            }
        }
        return -1;
    }

    public int binSearch(int[] nums, int low, int high, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
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

    @Test
    public void test() {
//        int[] nums = {1};
//        int[] nums = {1,2};
//        int[] nums = {1,2,3};
//        int[] nums = {1, 2, 0};
//        int[] nums = {2, 0, 1};
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int[] nums = {3, 4, 5, 6, 1, 2};
        System.out.println(searchIndex(nums));
        int result = searchRotatedSortedArray(nums, 2);
        System.out.println(result);
    }
}
