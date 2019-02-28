package jianzhioffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 15:52
 * @Description: 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出
 * 这三个数字能排成的最小数字为321323。
 * 贪心
 */
public class PrintMinNumber {
    class minHeap implements Comparator<String> {
        @Override
        public int compare(String i1, String i2) {
            String s1 = i1 + i2;
            String s2 = i2 + i1;
            return s1.compareTo(s2);
        }
    }

    public String PrintMinNumber(int[] numbers) {
//        Arrays.sort(numbers, new minHeap());
        String[] strs = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strs[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strs, new minHeap());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}
