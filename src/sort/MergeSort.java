package sort;

import org.junit.Test;

import java.util.Arrays;

public class MergeSort {

    /**
     * 归并排序是稳定排序，利用完全二叉树特性的排序一般性能都不会太差。
     * java中Arrays.sort()采用了一种名为TimSort的排序算法，就是归并排序的优化版本。
     * 每次合并操作的平均时间复杂度为O(n)，而完全二叉树的深度为|log2n|。总的平均时
     * 间复杂度为O(nlogn)。而且，归并排序的最好，最坏，平均时间复杂度均为O(nlogn)。
     */
    public void mergeSort(Integer[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        Integer[] temp = new Integer[nums.length];
        mSort(nums, 0, nums.length - 1, temp);
    }

    private void mSort(Integer[] nums, int start, int end, Integer[] temp) {
        //这里一定要注意的是不能有== start>=end不行
        if (start != end) {
//            int mid = (start + end) / 2;
            // 1.可以防止溢出int的范围
            // 2.使用右移操作快
            // 3.这里一定要注意的是括号
            int mid = start + ((end - start) >> 1);
            mSort(nums, start, mid, temp);
            mSort(nums, mid + 1, end, temp);
            merge(nums, start, mid, end, temp);
        }
    }

    private void merge(Integer[] nums, int start, int mid, int end, Integer[] temp) {
        int m = mid + 1;
        int b = start;
        int i = 0;
        while (start <= mid && m <= end) {
            if (nums[start] < nums[m]) {
                temp[i++] = nums[start++];
            } else {
                temp[i++] = nums[m++];
            }
        }
        while (start <= mid) {
            temp[i++] = nums[start++];
        }
        while (m <= end) {
            temp[i++] = nums[m++];
        }

        i = 0;
        //将temp数组拷贝到nums中
        while (b <= end) {
            nums[b++] = temp[i++];
        }
    }

    @Test
    public void testMergeSortedArray() {
        Integer[] A = {23, 4, 2, 34, 2, 34, 32};
        Integer[] B = {1, 1, 1, 1, 6, 245, 3, 234, 1, 1, 2, 46, 23, 45, 23423, 3, 4, 23};
        System.out.println("A" + Arrays.toString(A));
        System.out.println("B" + Arrays.toString(B));
        mergeSort(A);
        mergeSort(B);
        System.out.println("A" + Arrays.toString(A));
        System.out.println("B" + Arrays.toString(B));
    }
}
