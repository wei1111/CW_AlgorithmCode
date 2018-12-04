package string;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/4 13:13
 * @Description: 和java的String的contain方法作用同
 * next数组中规定0位置为-1，1位置为0，后面的根据前面的推
 */
public class KMP {
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }

        char[] ms = m.toCharArray();
        char[] ss = s.toCharArray();
        int[] next = getNextArray(ms);
        int mi = 0;
        int si = 0;
        while (mi < m.length() && si < s.length()) {
            if (ms[mi] == ss[si]) {
                mi++;
                si++;
            } else if (next[mi] == -1) {
                //这个时候next[mi] == -1此时si不可能匹配的到了，往后+
                si++;
            } else {
                mi = next[mi];
            }
        }
        return mi == ms.length ? si - m.length() : -1;
    }

    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int position = 2;
        //这里初始化时为0，因为2的前一个为1，而这个时候要比较的就是当前字符的前一个字符与前一个字符的next数组指向的字符是否相等
        //ababcababak 可以看到k对应的next数组的值为前面a的
        //要知道aaaaab中b的next值为4
        int provious = 0;
        while (position < ms.length) {
            if (ms[position - 1] == ms[provious]) {
                next[position++] = ++provious;
            } else if (provious > 0) {
                provious = next[provious];
            } else {
                next[position++]  = 0;
            }
        }
        return next;
    }

    @Test
    public void test() {
        String str1 = "chenwei 1";
        String str2 = "wei 1";
        int[] nextArray = getNextArray(str1.toCharArray());
        System.out.println(Arrays.toString(nextArray));

        System.out.println(getIndexOf(str1, str2));
    }
}
