package string;

import org.junit.Test;

import java.util.Arrays;

public class RotateString {
    /**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */

    /**
     * 8. 旋转字符串
     * 给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)
     * <p>
     * 样例
     * 对于字符串 "abcdefg". 6
     * <p>
     * offset=0 => "abcdefg"
     * offset=1 => "gabcdef"
     * offset=2 => "fgabcde"
     * offset=3 => "efgabcd"
     * <p>
     * 这个鸟题目测试用例中offset可能大于数组的长度，所以如果offset的长度过大则取余数
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        if (str.length == 0) {
            offset = 0;
        } else {
            offset = offset % str.length;
        }
        String s1 = "";
        String s2 = "";
        for (int i = 0; i < str.length - offset; i++) {
            s1 += str[i];
        }
        for (int i = str.length - offset; i < str.length; i++) {
            s2 += str[i];
        }
        char[] ch = (s2 + s1).toCharArray();
        for (int i = 0; i < str.length; i++) {
            str[i] = ch[i];
        }
    }

    @Test
    public void testDigitCounts() {
        char ch[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        rotateString(ch, 2);
        System.out.println(Arrays.toString(ch));
    }
}
