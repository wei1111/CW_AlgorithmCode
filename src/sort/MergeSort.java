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
    public void mergeSort(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
    }

    private void mergeSort(int[] nums, int start, int end, int[] temp) {
//        0 3 2
//        0 4 3
        //这里+1就是向上取整，下面左子序列就是mid-1
        //这里不+1就是向下取整，下面右子序列就是mid+1
        int mid = (start + end) / 2 + 1;
        if (start < end) {
            //左边归并排序，使得左子序列有序
            mergeSort(nums, start, mid - 1, temp);
            //右边归并排序，使得右子序列有序
            mergeSort(nums, mid, end, temp);
            //将两个有序子数组合并操作
            merge(nums, start, mid, end, temp);
        }
    }

    private void merge(int[] nums, int start, int mid, int end, int[] temp) {
        int l = start;
        int r = mid;
        int t = 0;
        while (l < mid && r <= end) {
            if (nums[l] < nums[r]) {
                temp[t++] = nums[l++];
            } else {
                temp[t++] = nums[r++];
            }
        }

        //可能右边的都放到temp中了
        while (l < mid) {
            temp[t++] = nums[l++];
        }
        while (r <= end) {
            temp[t++] = nums[r++];
        }

        t = 0;
        //将temp数组拷贝到nums中
        while (start <= end) {
            nums[start++] = temp[t++];
        }
    }

    @Test
    public void testMergeSortedArray() {
        int[] A = {23, 4, 2, 34, 2, 34, 32};
        int[] B = {1, 1, 1, 1, 6, 245, 3, 234, 1, 1, 2, 46, 23, 45, 23423, 3, 4, 23};
        System.out.println("A" + Arrays.toString(A));
        System.out.println("B" + Arrays.toString(B));
        mergeSort(A);
        mergeSort(B);
        System.out.println("A" + Arrays.toString(A));
        System.out.println("B" + Arrays.toString(B));
    }
}
