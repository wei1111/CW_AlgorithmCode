package sort;

import org.junit.Test;
import utils.SwapUtil;

import java.util.Arrays;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/18 17:19
 * @Description:
 */
public class Demo {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        //快排
        if (start > end) {
            return;
        }
        int random = start + (int) Math.random() * (end - start + 1);
        int[] partition = partition(arr, start, end, arr[random]);
        quickSort(arr, start, partition[0] - 1);
        quickSort(arr, partition[1] + 1, end);
    }

    private static int[] partition(int[] arr, int start, int end, int random) {
        int less = start - 1;
        int more = end + 1;
        while (start < more) {
            if (arr[start] < random) {
                SwapUtil.swap(arr, ++less, start++);
            } else if (arr[start] > random) {
                SwapUtil.swap(arr, --more, start);
            } else {
                start++;
            }
        }

        return new int[]{less + 1, more - 1};
    }


    @Test
    public void test() {
        int[] nums = new int[]{4, 6, 8, 5, 9};
        System.out.println("排前：" + Arrays.toString(nums));

        quickSort(nums);
        System.out.println("排后：" + Arrays.toString(nums));
    }


    @Test
    public void testHeapSort() {
        int[] nums = new int[]{4, 4, 4, 4, 4, 5, 1};
        System.out.println("排前：" + Arrays.toString(nums));

        heapSort(nums);
        System.out.println("排后：" + Arrays.toString(nums));
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int len = arr.length;
        //建堆
        for (int i = (len - 1) / 2; i >= 0; i--) {
            adjustHeap(arr, i, len - 1);
        }

        //排序
        for (int i = len - 1; i > 0; i--) {
            SwapUtil.swap(arr, i, 0);
            adjustHeap(arr, 0, i - 1);
        }
    }

    private static void adjustHeap(int[] arr, int index, int len) {
        for (int i = 2 * index + 1; i <= len; i = 2 * index + 1) {
            if (i + 1 <= len) {
                if (arr[i + 1] > arr[i]) {
                    i = i + 1;
                }
            }
            if (arr[i] > arr[index]) {
                SwapUtil.swap(arr, index, i);
                index = i;
            } else {
                break;
            }
        }
    }


    @Test
    public void testMerge() {
//        int[] nums = new int[]{4, 6, 8, 5, 9};
        int[] nums = new int[]{4, 4, 4, 4, 4, 5, 1};
        System.out.println("堆排前：" + Arrays.toString(nums));
        mergeSort(nums);
        System.out.println("堆排后：" + Arrays.toString(nums));
    }

    private static void mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int len = nums.length;
        int[] temp = new int[len];
        mergeSort(nums, 0, len - 1, temp);
    }

    private static void mergeSort(int[] nums, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        int mid = start + ((end - start) >> 1);
        mergeSort(nums, start, mid, temp);
        mergeSort(nums, mid + 1, end, temp);
        merge(nums, start, mid, end, temp);
    }

    private static void merge(int[] nums, int start, int mid, int end, int[] temp) {
        int m = mid + 1;
        int s = start;
        int t = start;
        while (s <= mid && m <= end) {
            if (nums[s] <= nums[m]) {
                temp[t++] = nums[s++];
            } else {
                temp[t++] = nums[m++];
            }
        }
        while (s <= mid) {
            temp[t++] = nums[s++];
        }
        while (m <= end) {
            temp[t++] = nums[m++];
        }
        while (start <= end) {
            nums[start] = temp[start++];
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
//            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr1 = {1, 1};
            int[] arr2 = copyArray(arr1);
//            quickSort(arr1);
            heapSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
//        quickSort(arr);
        heapSort(arr);
        printArray(arr);
    }

}
