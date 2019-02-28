package jianzhioffer;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 18:48
 * @Description: 将一个字符串转换成一个整数(实现Integer.valueOf ( string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 数值为0
 * 或者字符串不是一个合法的数值则返回0。
 */
public class StrToInt {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chs = str.toCharArray();
        boolean isFS = false;
        int len = chs.length;
        int begin = 0;
        if (chs[0] == '-') {
            if (len == 1) {
                return 0;
            }
            begin++;
            isFS = true;
        }
        if (chs[0] == '+') {
            if (len == 1) {
                return 0;
            }
            begin++;
        }
        int x = 1;
        int result = 0;
        for (int i = len - 1; i >= begin; i--) {
            int c = chs[i] - '0';
            if (c >= 0 && c <= 9) {
                result += (c * x);
                x *= 10;
            } else {
                return 0;
            }
        }
        if (isFS) {
            result = -result;
        }
        return result;
    }
}
