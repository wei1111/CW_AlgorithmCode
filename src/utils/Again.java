package utils;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/5 21:44
 * @Description:
 */
public class Again {
    public void quickSort(Integer[] nums) {
        qSort(nums, 0, nums.length - 1);
    }

    private void qSort(Integer[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int flag = nums[start];
        int l = start;
        int r = end;

        while (l < r) {
            while (l < r && nums[r] >= flag) {
                r--;
            }
            while (l < r && nums[l] <= flag) {
                l++;
            }
            SwapUtil.swap(nums, l, r);
        }

        SwapUtil.swap(nums, start, l);
        nums[l] = flag;
        qSort(nums, start, l - 1);
        qSort(nums, l + 1, end);
    }

    public void heapSort(Integer[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }
        System.out.println("建堆: " + Arrays.toString(nums));

        for (int i = nums.length - 1; i > 0; i--) {
            SwapUtil.swap(nums, i, 0);
            adjustHeap(nums, 0, i);
        }
    }

    public void mergeSort(Integer[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        Integer[] temp = new Integer[nums.length];
        mSort(nums, 0, nums.length - 1, temp);
    }

    private void mSort(Integer[] nums, int start, int end, Integer[] temp) {
        if (start < end) {
//            int mid = (start + end) / 2;
            int mid = start + (end - start) >> 1;
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
            if (nums[start] <= nums[m]) {
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

    private void adjustHeap(Integer[] nums, int i, int length) {
        for (int j = 2 * i + 1; j < length; j = 2 * i + 1) {
            if (j + 1 < length && nums[j + 1] > nums[j]) {
                j = j + 1;
            }
            if (nums[j] > nums[i]) {
                SwapUtil.swap(nums, i, j);
                i = j;
            } else {
                break;
            }
        }
    }


    //二分查找
    public int binSearch(int[] nums, int target) {
        int len = nums.length;
        int result = bSearch(nums, 0, len - 1, target);
        return result;
    }

    private int bSearch(int[] nums, int start, int end, int target) {
        int mid = (start + end) / 2;
        if (start <= end) {
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                return bSearch(nums, start, mid - 1, target);
            }
            if (nums[mid] < target) {
                return bSearch(nums, mid + 1, end, target);
            }
        }
        return -1;
    }

    private int bSearch2(int[] nums, int start, int end, int target) {
        int mid = (start + end) / 2;
        while (start <= end) {
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }
        return -1;
    }


    @Test
    public void testBinSearch() {
        int[] nums = {1};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int x = 1;
        System.out.println("正确：" + Arrays.binarySearch(nums, x));
        System.out.println(binSearch(nums, x));
    }

    @Test
    public void test() {
        Integer[] nums = {1, 1, 1, 1, 23, 2334, 2, 2, 34, 2342, 7, 9, 3, 4, 5, 10, 8};
        System.out.println(Arrays.toString(nums));
        quickSort(nums);
        System.out.println("sort: " + Arrays.toString(nums));

        Integer[] heapNums =
                new Integer[]{1, 1, 1, 1, 23, 2334, 2, 2, 34, 2342, 7, 9, 3, 4, 5, 10, 8};
        System.out.println("heapSort前: " + Arrays.toString(heapNums));
        heapSort(heapNums);
        System.out.println("heapSort后: " + Arrays.toString(heapNums));

        Integer[] mergeNums =
                new Integer[]{1, 1, 1, 1, 23, 2334, 2, 2, 34, 2342, 7, 9, 3, 4, 5, 10, 8};
        System.out.println("mergeSort前: " + Arrays.toString(mergeNums));
        mergeSort(mergeNums);
        System.out.println("mergeSort后: " + Arrays.toString(mergeNums));
    }
}
