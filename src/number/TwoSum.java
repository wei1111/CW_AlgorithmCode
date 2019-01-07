package number;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/27 20:58
 * @Description: 1. Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int reduce = target - nums[i];
            if (hashMap.containsKey(reduce)) {
                return new int[]{i, hashMap.get(reduce)};
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    @Test
    public void test() {
        int[] nums = {2, 7, 11, 15};
        twoSum(nums, 9);
        System.out.println(nums[0] + " " + nums[1]);
    }
}
