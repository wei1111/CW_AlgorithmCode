package jianzhioffer;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 18:50
 * @Description: 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现
 * 任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个
 * 模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"
 * 和"ab*a"均不匹配
 */
public class Match {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int slen = str.length;
        int plen = pattern.length;
        int i = 0, j = 0;
        for (; i < slen && j < plen; i++, j++) {
            if (str[i] != pattern[j]) {
                if (pattern[j] == '.') {
                    while (j + 1 < plen && pattern[j + 1] == '*') {
                        j++;
                    }
                } else if (pattern[j] == '*') {
                    j++;
                } else {
                    while (j + 1 < plen) {
                        if (pattern[j + 1] == pattern[j]) {
                            j++;
                        } else if (pattern[j + 1] == '*') {
                            j++;
                            break;
                        } else {
                            return false;
                        }
                    }
                }

            }
        }
        return i == slen && j == plen;
    }
}
