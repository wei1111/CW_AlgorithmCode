package jianzhioffer;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/8 22:52
 * @Description:
 * 题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为
 * We%20Are%20Happy。
 *
 * 一行JAVA代码搞定
 * return str.toString().replaceAll(" " , "%20");
 */
public class ReplaceSpace {
    public String replaceSpace1(StringBuffer str) {
        int l = str.length();
        int size = 0;
        for (int i = 0; i < l; i++) {
            if (str.charAt(i) == ' ') {
                size++;
            }
        }
        char[] chars = new char[str.length() + size * 2];
        int cursor = chars.length-1;
        str.getChars(0,str.length(),chars,0);
        for (int i = str.length()-1; i >=0; i--) {
            if (str.charAt(i) != ' ') {
                chars[cursor] = str.charAt(i);
                cursor--;
            }
            else {
                chars[cursor] = '0';
                chars[--cursor] = '2';
                chars[--cursor] = '%';
                cursor--;
            }
        }
        return new String(chars);
    }

    public String replaceSpace2(StringBuffer str) {
        return str.toString().replaceAll(" " , "%20");
    }

    public String replaceSpace3(StringBuffer str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int s = 0; s < str.length(); s++) {
            if (str.charAt(s) == ' ') {
                stringBuffer.append("%20");
            } else {
                stringBuffer.append(str.charAt(s));
            }
        }
        return stringBuffer.toString();
    }

    @Test
    public void test() {
        String s1 = replaceSpace1(new StringBuffer("hello world!"));
        String s2 = replaceSpace2(new StringBuffer("hello world!"));
        String s3 = replaceSpace3(new StringBuffer("hello world!"));
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
