package utils;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/5 19:57
 * @Description:
 */
public class SwapUtil {
    public static <T extends Comparable> void swap(T[] comparables, int x, int y) {
        T t = comparables[y];
        comparables[y] = comparables[x];
        comparables[x] = t;
    }

    public void swap(int[] arr, int x, int y){
        if (arr == null || arr.length == 0 || x < 0 || y >= arr.length) {
            return;
        }
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
