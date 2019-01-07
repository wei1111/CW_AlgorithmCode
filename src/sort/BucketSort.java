package sort;

import org.junit.Test;
import utils.VerificationUtil;

import java.util.Arrays;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/27 21:26
 * @Description: 桶排序，基数排序的一种
 */
public class BucketSort {
    // only for 0~200 value，因为数字大了的话数组会开辟的太大了。。。
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int[] ints = generateRandomArray(30, 50);
            int[] arr1 = ints.clone();
            Arrays.sort(arr1);
            System.out.println(Arrays.toString(ints));
            int[] arr2 = bucketSort(ints);
            System.out.println(Arrays.toString(ints));
            if (!VerificationUtil.isEqual(arr1, arr2)) {
                System.out.println("Shit!!!!!!!");
            }
        }
    }

    public static int[] bucketSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (max < i) {
                max = i;
            }
        }
        int[] bucket = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        int j = 0;
        for (int i = 0; i < bucket.length; i++) {
            // 唯一要注意的是这里
            while (bucket[i]-- > 0) {
                arr[j++] = i;
            }
        }
        return arr;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    @Test
    public void test() {
        int x = 1;
        int d = 2;
        int y = (x / (int) Math.pow(10, d - 1)) % 10;
        System.out.println(y);

//        int[] ints = generateRandomArray(33, 33);
//        System.out.println(Arrays.toString(ints));
//        bucketSort(ints);
//        System.out.println(Arrays.toString(ints));
    }
}
