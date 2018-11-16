package sort;

import org.junit.Test;

import java.util.Arrays;

public class PartitionArray {
    /**
     * @param nums: The integer array you should partition
     * @param k:    An integer
     * @return: The index after partition
     * <p>
     * 31. 数组划分
     * 给出一个整数数组 nums 和一个整数 k。划分数组（即移动数组 nums 中的元素），使得：
     * <p>
     * 所有小于k的元素移到左边
     * 所有大于等于k的元素移到右边
     * 返回数组划分的位置，即数组中第一个位置 i，满足 nums[i] 大于等于 k。
     * <p>
     * 样例
     * 给出数组 nums = [3,2,2,1] 和 k = 2，返回 1.
     * <p>
     * 挑战
     * 使用 O(n) 的时间复杂度在数组上进行划分。
     * <p>
     * 注意事项
     * 你应该真正的划分数组 nums，而不仅仅只是计算比 k 小的整数数，如果数组 nums 中的所有元素都比 k 小，则返回 nums.length。
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here
        int i = 0;
        int j = nums.length - 1;
        int temp = 0;
        if (nums.length == 0) {
            return 0;
        }
        while (j > i) {
            while (nums[j] >= k && j > i) {
                j--;
            }
            while (nums[i] <= k && j > i) {
                i++;
            }
            temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        if (i == 0 && nums[0] >= k) {
            return i;
        }
        return i + 1;
    }

    @Test
    public void testQuickSort() {
//        int[] nums = {3, 2, 2, 1};
        //3
        int[] nums = {3, 2, 3, 3, 2, 1};
        System.out.println(partitionArray(nums, 2));
        System.out.println(Arrays.toString(nums));
    }
}
