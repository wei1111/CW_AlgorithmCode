package number;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/20 18:10
 * @Description: 二分左边的, 二分右边的
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        int left = -2;
        while (low <= high) {
            mid = low + (high - low >> 1);
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
                if (nums[mid] == target) {
                    left = high;
                }
            }
        }
        if (left < -1) {
            return new int[]{-1, -1};
        }
        low = left + 1;
        high = nums.length - 1;
        while (low <= high) {
            mid = low + (high - low >> 1);
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{left + 1, low - 1};
    }

    @Test
    public void test() {
        int sf = Integer.parseInt(null);
        int[] nums = {5, 5, 7, 8, 8, 10};
        int[] ints = searchRange(nums, 5);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}
