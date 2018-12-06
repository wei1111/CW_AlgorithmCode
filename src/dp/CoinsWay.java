package dp;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/5 17:51
 * @Description:
 */
public class CoinsWay {
    public int coins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim <= 0) {
            return 0;
        }

        return process1(arr, 0, aim);
    }

    //其中index为第几种面值的钱
    private int process1(int[] arr, int index, int aim) {
        int result  = 0;
        if (index == arr.length) {
            return aim == 0 ? 1 : 0;
        }
        int piece = 0;
        while (piece * arr[index] <= aim) {
            result += process1(arr, index + 1, aim - piece * arr[index]);
            piece++;
        }
        return result;
    }

    @Test
    public void test() {

//        int[] coins = {10, 5, 1, 25};
//        int aim = 2000;
//        System.out.println(coins1(coins, aim));

        int a = 2;
        System.out.println(2>>1);
        System.out.println(2<<1);
        System.out.println(2>>>1);
        System.out.println(-2>>1);
        System.out.println(-2<<1);
        System.out.println(-2>>>1);
        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(-2));
        System.out.println(Integer.toBinaryString(-2>>>1));
        System.out.println(Integer.toBinaryString(-2>>1));

        char ch = '中';
        System.out.println("char:" + ch);
    }
}
