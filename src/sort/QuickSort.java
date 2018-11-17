package sort;

import org.junit.Test;
import utils.SwapUtil;

import java.util.Arrays;

/**
 * 稳定性
 * 不是稳定的，比如待排序数组为5，7，7，1，1。那么若以数组中第一元素做为换分依据，
 * 第一次划结果为1,1,5,7,7。但是（从左往右）第一个7和第二个1交换，第二个7和第一个
 * 1交换，所以交换后1和1,7和7的相对位置都变了，所以显然是不稳定的。
 */

/**
 * 复杂度
 * nlogn
 */

public class QuickSort {
    public void quickSort(int i, int j, Comparable[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        if (i >= j) {
            return;
        }
        Comparable flag = nums[i];
        int y = j;
        int x = i;
        Comparable t = null;
        while (y > x) {
            while (nums[y].compareTo(flag) >= 0 && y > x) {
                y--;
            }
            while (nums[x].compareTo(flag) <= 0 && y > x) {
                x++;
            }
            t = nums[y];
            nums[y] = nums[x];
            nums[x] = t;
        }
//        System.out.println(x+":"+y);
        nums[i] = nums[y];
        nums[y] = flag;


        quickSort(i, y - 1, nums);
        quickSort(y + 1, j, nums);
    }

    @Test
    public void testQuickSort() {
//        Integer[] nums = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        Integer[] nums = {1, 1, 1, 1, 23, 2334, 2, 2, 34, 234};//2, 7, 9, 3, 4, 5, 10, 8};
        System.out.println(Arrays.toString(nums));
        quickSort(0, nums.length - 1, nums);
        System.out.println("quickSort: " + Arrays.toString(nums));
        qSort(0, nums.length - 1, nums);
        System.out.println("qSort: " + Arrays.toString(nums));
    }

    public void qSort(int f, int l, Integer[] nums) {
        int beg = f;
        int end = l;
        if (beg > end) {
            return;
        }
        int flag = nums[f];

        while (l > f) {
            while (l > f && nums[l] >= flag) {
                l--;
            }
            while (l > f && nums[f] <= flag) {
                f++;
            }
            SwapUtil.swap(nums, f, l);
        }
        SwapUtil.swap(nums, beg, l);
        qSort(beg, l - 1, nums);
        qSort(l + 1, end, nums);
    }


    /**
     * @param left
     * @param right
     * @param comparables
     * @param <T>         new 数字，如果直接初始化则不可以给大小
     *                    给大小只能是int
     */
    public <T extends Comparable> void partition(int left, int right,
                                                 T[] comparables) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;

        T flag = comparables[left];
        while (right > left) {
            while (right > left && comparables[right].compareTo(flag) >= 0) {
                right--;
            }
            while (right > left && comparables[left].compareTo(flag) <= 0) {
                left++;
            }
            if (right > left) {
                SwapUtil.swap(comparables, left, right);
            }
        }
        comparables[l] = comparables[right];
        comparables[right] = flag;

        partition(l, right - 1, comparables);
        partition(right + 1, r, comparables);
    }

    @Test
    public void test() {
        Integer[] nums = {1, 1, 1, 1, 23, 2334, 2, 2, 34, 2342, 7, 9, 3, 4, 5, 10, 8};
        System.out.println(Arrays.toString(nums));
        partition(0, nums.length - 1, nums);
        System.out.println("partition: " + Arrays.toString(nums));
    }
}
