package utils;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/5 21:44
 * @Description:
 */
public class Again {
    class ReturnType {
        int start;
        int end;

        public ReturnType(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    @Test
    public void test() {
        Integer[] nums = {1, 1, 1, 1, 23, 2334, 2, 2, 34, 2342, 7, 9, 3, 4, 5, 10, 8};
        System.out.println(Arrays.toString(nums));
        quickSort(nums);
        System.out.println("quickSort: " + Arrays.toString(nums));

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

    private void mergeSort(Integer[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        mSort(nums, 0, nums.length - 1, new Integer[nums.length]);

    }

    private void mSort(Integer[] nums, int start, int end, Integer[] temp) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mSort(nums, start, mid, temp);
        mSort(nums, mid + 1, end, temp);
        merge(nums, start, mid, end, temp);
    }

    private void merge(Integer[] nums, int start, int mid, int end, Integer[] temp) {
        int m = mid + 1;
        int t = start;
        int s = start;
        while (start <= mid && m <= end) {
            if (nums[start] <= nums[m]) {
                temp[t++] = nums[start++];
            } else {
                temp[t++] = nums[m++];
            }
        }
        while (start <= mid) {
            temp[t++] = nums[start++];
        }
        while (m <= end) {
            temp[t++] = nums[m++];
        }
        for (int i = s; i <= end; i++) {
            nums[i] = temp[i];
        }
    }

    private void heapSort(Integer[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        //建堆
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjust(nums, i, nums.length);
        }
        //排序
        for (int i = nums.length - 1; i > 0; i--) {
            SwapUtil.swap(nums, 0, i);
            adjust(nums, 0, i - 1);
        }
    }

    private void adjust(Integer[] nums, int i, int length) {
        for (int j = 2 * i + 1; j < length; j = 2 * i + 1) {
            if (j + 1 < length) {
                j = nums[j + 1] > nums[j] ? j + 1 : j;
            }
            if (nums[j] > nums[i]) {
                SwapUtil.swap(nums, j, i);
                i = j;
            } else {
                break;
            }
        }
    }


    private void quickSort(Integer[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        qSort(nums, 0, nums.length - 1);
    }

    private void qSort(Integer[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        Integer random = start + (int) Math.random() * (end - start + 1);
        random = nums[random];

        ReturnType returnType = partition(nums, start, end, random);
        qSort(nums, start, returnType.start - 1);
        qSort(nums, returnType.end + 1, end);
    }

    private ReturnType partition(Integer[] nums, int start, int end, Integer random) {
        int less = start - 1;
        int more = end + 1;
        while (start < more) {
            if (nums[start] < random) {
//                nums[++less] = nums[start++];
                SwapUtil.swap(nums, ++less, start++);
            } else if (nums[start] > random) {
//                nums[--more] = nums[start];
                SwapUtil.swap(nums, --more, start);
            } else {
                start++;
            }
        }
        return new ReturnType(less + 1, more - 1);
    }

}
