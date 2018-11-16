package number;

import org.junit.Test;

public class DigitCounts {
    /**
     * @param : An integer
     * @param : An integer
     * @return: An integer denote the count of digit k in 1..n
     */

    /**
     * 统计数字
     * 计算数字k在0到n中的出现的次数，k可能是0~9的一个值
     *
     * 样例
     * 例如n=12，k=1，在 [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]，我们发现1出现了5次 (1, 10, 11, 12)

     * axyzb 456 k=5
     * x<5 k在x位上出现的次数为a*10000
     * y=5 k在y位上出现的次数为ax*1000+zb+1
     * z>5 k在z位上出现的次数为(axy+1)*100
     * <p>
     * 当某一位的数字小于i时，那么该位出现i的次数为：更高位数字*当前位数
     * 当某一位的数字等于i时，那么该位出现i的次数为：更高位数字*当前位数+低位数字+1
     * 当某一位的数字大于i时，那么该位出现i的次数为：(更高位数字+1)*当前位数
     */
    public int digitCounts(int k, int n) {
        // write your code here
        int sum = 0;
        String s1 = "", s2 = "";
        String str = Integer.toString(n);
        char[] chars = str.toCharArray();

        int i = str.length();
        for (int j = i - 1, t = 1; j >= 0; j--, t *= 10) {
            if (j > 0) {
                s1 = str.substring(0, j);
            } else {
                s1 = "0";
            }
            if (j == i - 1) {
                s2 = "0";
            } else {
                s2 = str.substring(j + 1);
            }
            int t1 = Integer.parseInt(s1);
            int t2 = Integer.parseInt(s2);
            if ((chars[j] - 48) < k) {
                sum += t1 * t;
            } else if ((chars[j] - 48) == k) {
                sum += t1 * t + t2 + 1;
            } else {
                if (k == 0 && t1 == 0 && t2 != 0) {
                } else {
                    sum += (t1 + 1) * t;
                }
            }
        }
        return sum;
    }

    @Test
    public void testDigitCounts() {
        System.out.println(digitCounts(0, 10));
        System.out.println(digitCounts(0, 9));//161
        char ch = '0';
    }
}
