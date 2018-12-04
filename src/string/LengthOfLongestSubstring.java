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
