package utils;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/16 21:04
 * @Description:
 */
public class VerificationUtil {
    // for test 随机数组生成器
    /*
     * Math.random() -> double[0,1)
     * (int) ((size + 1) * Math.random()) -> [0, size]
     * size = 6, size + 1 = 7
     * Math.random() -> [0,1) * 7 -> [0,7)double
     * double -> int[0,6] -> int
     */
    public static Integer[] generateRandomArray(int size, int range) {
        //产生的数组长度是[0, size]
        Integer[] arr = new Integer[(int) ((size + 1) * Math.random())];
//        System.out.println(arr.length);
        //产生的数组中的数的范围是-value ~ value
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((range + 1) * Math.random()
                    - (int) (range * Math.random()));
        }
        return arr;
    }

    // for test
    public static int[] getRandomIntArray(int maxLen, int maxValue) {
        int[] res = new int[(int) (Math.random() * maxLen) + 1];
        for (int i = 0; i != res.length; i++) {
            res[i] = (int) (Math.random() * maxValue);
        }
        return res;
    }

    public static int[] getLenRandomIntArray(int len, int maxValue) {
        int[] res = new int[len];
        for (int i = 0; i != res.length; i++) {
            res[i] = (int) (Math.random() * maxValue);
        }
        return res;
    }

    //判断两个数组是否相等
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
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
