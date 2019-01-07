package number;

/**
 * @Author: wei1
 * @Date: Create in 2019/1/8 0:23
 * @Description:
 */
public class FindNumsAppearSomeTimes {
    /**
     * 数组中有两个出现一次的数字，其他数字都出现两次，找出这两个数字
     *
     * @param array
     * @param num1
     * @param num2
     */
    public static void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length <= 1) {
            num1[0] = num2[0] = 0;
            return;
        }
        int len = array.length, index = 0, sum = 0;
        for (int i = 0; i < len; i++) {
            sum ^= array[i];
        }
        for (index = 0; index < 32; index++) {
            if ((sum & (1 << index)) != 0) {
                break;
            }
        }
        for (int i = 0; i < len; i++) {
            if ((array[i] & (1 << index)) != 0) {
                num2[0] ^= array[i];
            } else {
                num1[0] ^= array[i];
            }
        }
    }

    /**
     * 数组a中只有一个数出现一次，其他数都出现了2次，找出这个数字
     *
     * @param a
     * @return
     */
    public static int find1From2(int[] a) {
        int len = a.length, res = 0;
        for (int i = 0; i < len; i++) {
            res = res ^ a[i];
        }
        return res;
    }

    /**
     * 数组a中只有一个数出现一次，其他数字都出现了3次，找出这个数字
     *
     * @param a
     * @return
     */
    public static int find1From3(int[] a) {
        int[] bits = new int[32];
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 32; j++) {
                bits[j] = bits[j] + ((a[i] >>> j) & 1);
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] % 3 != 0) {
                res = res | (1 << i);
            }
        }
        return res;
    }

    /**
     * 数组a中只有一个数出现一次，其他数字都出现了n次，找出这个数字
     *
     * @param a
     * @return
     */
    public static int find1FromN(int[] a, int n) {
        int[] bits = new int[32];
        int len = a.length;
        //得到所有数字所在bit位上的和
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 32; j++) {
                bits[j] += (a[i] >>> j) & 1;
            }
        }

        int result = 0;
        for (int j = 0; j < 32; j++) {
            if (bits[j] % n != 0) {
                result |= (1 << j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 1, 2, 2, 3, 3, 4, 5, 5};
        System.out.println(find1From2(test1));
        System.out.println(find1FromN(test1, 2));

        int[] test2 = {0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        System.out.println(find1From2(test2));
        System.out.println(find1FromN(test2, 2));

        int[] test3 = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 5, 5, 5};
        System.out.println(find1From3(test3));
        System.out.println(find1FromN(test3, 3));

        int[] test4 = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 5, 5, 5, 5};
        System.out.println(find1FromN(test4, 4));
    }
}
