package jianzhioffer;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 18:26
 * @Description: 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if(str == null || n>str.length()){
            return "";
        }
        String str1 = str.substring(0,n);
        String str2 = str.substring(n,str.length());
        StringBuilder sb1 = new StringBuilder(str1);
        StringBuilder sb2 = new StringBuilder(str2);
        sb1.reverse().append(sb2.reverse());
        sb1.reverse();
        return sb1.toString();
    }
}
