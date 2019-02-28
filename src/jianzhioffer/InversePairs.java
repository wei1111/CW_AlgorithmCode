package jianzhioffer;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 18:19
 * @Description: 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的
 * 总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 逆序对问题，明显的mergesort 归并排序的merge写法
 */
public class InversePairs {
    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] temp = new int[array.length];
        int result = mergeSort(array, 0, array.length - 1, temp);
        return result;
    }

    public int mergeSort(int[] arr, int start, int end, int[] temp) {
        if (start >= end) {
            return 0;
        }
        int mid = start + ((end - start) >> 1);
        int x1 = mergeSort(arr, start, mid, temp);
        int x2 = mergeSort(arr, mid + 1, end, temp);
        int x3 = merge(arr, start, mid, end, temp);
        return (x1 + x2 + x3) % 1000000007;
    }

    public int merge(int[] arr, int start, int mid, int end, int[] temp) {
        int result = 0;
        int s = start;
        int m = mid + 1;
        int t = start;
        while (s <= mid && m <= end) {
            if (arr[s] > arr[m]) {
                result += (mid - s + 1);
                result %= 1000000007;
                temp[t++] = arr[m++];
            } else if (arr[s] <= arr[m]) {
                temp[t++] = arr[s++];
            }
        }
        while (s <= mid) {
            temp[t++] = arr[s++];
        }
        while (m <= end) {
            temp[t++] = arr[m++];
        }
        while (start <= end) {
            arr[start] = temp[start++];
        }
        return result;
    }
}
