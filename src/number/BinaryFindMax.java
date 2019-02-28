package number;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 10:13
 * @Description: 先递增后递减数组查找最大值
 */
public class BinaryFindMax {
    public int findMax(int[] arr) {
        int len = arr.length;
        int mid = (len - 1) >> 1;
        int begin = 0;
        int end = len - 1;
//        while (mid > 0 && mid < arr.length - 1) {
        while (begin <= end) {
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] < arr[mid + 1]) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = begin + ((end - begin) >> 1);
        }
        if (mid == 0) {
            return 0;
        }
        if (mid == len - 1) {
            return len - 1;
        }
        return -1;
    }

    @Test
    public void test() {
        System.out.println(findMax(new int[]{1, 2, 3, 4, 2, 1}));

    }
}
