package sort;

import org.junit.Test;

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
        if (start < end) {
            int ra = start + (int) (Math.random() * (end - start + 1));
            int aim = arr[ra];
            int[] partition = partition(arr, start, end, aim);

            quickSort(arr, start, partition[0] - 1);
            quickSort(arr, partition[1] + 1, end);
        }
    }

    @Test
    public void test() {
        int[] nums = new int[]{4, 6, 8, 5, 9};
        System.out.println("排前：" + Arrays.toString(nums));

        quickSort(nums);
        System.out.println("排后：" + Arrays.toString(nums));
    }

    private static int[] partition(int[] arr, int start, int end, int aim) {
        int less = start - 1;
        int more = end + 1;
        while (start < more) {
            if (arr[start] < aim) {
                swap(arr, ++less, start++);
            } else if (arr[start] > aim) {
                swap(arr, --more, start);
            } else {
                start++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //建堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length - 1);
        }

        //排序
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, i, 0);
            adjustHeap(arr, 0, i - 1);
        }
    }


    private static void adjustHeap(int[] arr, int i, int length) {
        for (int j = 2 * i + 1; j <= length; j = 2 * i + 1) {
            if (j + 1 <= length) {
                if (arr[j + 1] > arr[j]) {
                    j++;
                }
            }
            if (arr[i] < arr[j]) {
                swap(arr, j, i);
                i = j;
            } else {
                break;
            }
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    @Test
    public void testMerge() {
        int[] nums = new int[]{4, 6, 8, 5, 9};
        System.out.println("堆排前：" + Arrays.toString(nums));
        mergeSort(nums);
        System.out.println("堆排后：" + Arrays.toString(nums));
    }

    private static void mergeSort(int[] arr, int start, int end, int[] temp) {
        if (start < end) {
            int mid = start + ((end - start) >> 1);
            mergeSort(arr, start, mid, temp);
            mergeSort(arr, mid + 1, end, temp);
            merge(arr, start, mid, end, temp);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end, int[] temp) {
        int s = start;
        int m = mid + 1;
        int t = start;
        while (start <= mid && m <= end) {
            while (start <= mid && arr[start] <= arr[m]) {
                temp[t++] = arr[start++];
            }
            while (m <= end && arr[start] > arr[m]) {
                temp[t++] = arr[m++];
            }
        }
        while (m <= end) {
            temp[t++] = arr[m++];
        }
        while (start <= mid) {
            temp[t++] = arr[start++];
        }
        for (int i = s; i <= end; i++) {
            arr[i] = temp[i];
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
