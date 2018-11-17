package sort;

import org.junit.Test;
import utils.SwapUtil;

import java.util.Arrays;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/17 15:47
 * @Description:使用荷兰国旗改良过的快排
 * 这个是几乎最好的快排了，使用了随机选择划分的数
 * 空间复杂度为logn这个是最好的情况，在每次的划分的数在最中间的情况下，
 * 最差的情况下需要递归栈中记录的划分值就是partition的返回值为所有的数，那么就是n
 * 时间复杂度平均为nlogn
 * 不是稳定的排序
 */
public class QuickSort2 {
    public void quickSort(Integer[] nums) {
        qSort(nums, 0, nums.length - 1);
    }

    private void qSort(Integer[] nums, int start, int end) {
        if (start < end) {
            //在start end中随机找数进行partition这样保证nlogn
            int randomIndex = start + (int) Math.random() * (end - start + 1);
            Integer p = nums[randomIndex];

            int[] partition = partition(nums, start, end, p);
            qSort(nums, start, partition[0] - 1);
            qSort(nums, partition[1] + 1, end);
        }
    }

    private int[] partition(Integer[] nums, int start, int end, Integer p) {
        int less = start - 1;
        int more = end + 1;
//        p = nums[end];
        while (start < more) {
            if (nums[start] < p) {
                SwapUtil.swap(nums, ++less, start++);
            } else if (nums[start] > p) {
                SwapUtil.swap(nums, --more, start);
            } else {
                start++;
            }
        }

        System.out.println(p + " : " + Arrays.toString(nums));
        return new int[]{less + 1, more - 1};
    }

    @Test
    public void test() {
        Integer[] nums =
                {1, 1, 1, 1, 23, 2334, 2, 245, 2, 34, 5, 234, 5, 23, 42, 34, 2342, 7, 9, 3, 4, 5,
                        10, 8};
        System.out.println(Arrays.toString(nums));
        quickSort(nums);
        System.out.println("partition: " + Arrays.toString(nums));

        System.out.println((int)-1.5);
        System.out.println((int)-0.4);
        System.out.println((int)-0.9);
    }
}
