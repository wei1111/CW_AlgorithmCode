package string;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/4 22:26
 * @Description: 查找最长子串的长度（不重复字符）
 */
public class LengthOfLongestSubstring {
    /**
     * 滑动窗口思想：如果确定子串s[i,j]（假设表示字符串的第i个字符到第j-1个字符表示的子串），那么只需要比较s[j]是否与子串s[i,j]重复即可
     * <p>
     * 若重复：记录此时滑动窗口大小，并与最大滑动窗口比较，赋值。然后滑动窗口大小重定义为1，头位置不变，并右移一个单位。
     * <p>
     * 若不重复：滑动窗口头不变，结尾+1，整个窗口加大1个单位。继续比较下一个。
     */
    public static int lengthOfLongestSubstring(String s) {
        int begin = 0;
        int end = 0;
        int reslut = 0;
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        while (end < chars.length) {
            if (!set.contains(chars[end])) {
                set.add(chars[end++]);
            } else {
                set.remove(chars[begin++]);
            }
            reslut = reslut > set.size() ? reslut : set.size();
        }
        return reslut;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int start, end;
        String count = "";
        String str = "";
        for (start = 0; start < s.length(); start++) {
            for (end = start + 1; end <= s.length(); end++) {
                str = s.substring(start, end);
                if (end == s.length()) {
                    if (count.length() < str.length()) {//对比长度
                        count = str;
                    }
                    break;
                } else {
                    if (str.contains(s.substring(end, end + 1))) {//当有重复时候，处理，跳出循环让start++
                        if (count.length() < str.length()) {//对比长度
                            count = str;
                        }
                        break;
                    }
                }
            }
        }
        return count.length();
    }

    @Test
    public void test() {
        String str = "chenweifjasdfjasjdfajslddddddddfoajeofjasdjgoajsfksjaf[ojagl;ajs";
        int i = lengthOfLongestSubstring(str);
        int i1 = lengthOfLongestSubstring2(str);
        System.out.println(i + " : " + i1);
    }
}
