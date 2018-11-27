package dp;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/26 19:05
 * @Description:
 */
public class SubArrayMaxSum {
    public int subArrayMaxSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            max = cur > max ? cur : max;
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }

    @Test
    public void test() {
        int result = subArrayMaxSum(new int[]{5, 1, -2, 3, 4});
        System.out.println(result);
    }
}
