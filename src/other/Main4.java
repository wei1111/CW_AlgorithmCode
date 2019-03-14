package other;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: wei1
 * @Date: Create in 2019/3/10 17:56
 * @Description:
 */
public class Main4 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        getStr("(()", "())");
//        getStr(str1, str1);
    }

    public static void getStr(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        getStr(ch1, 0, ch2, 0, "");
        result = result % (1000000000+7);
        System.out.println(result);
    }

    static int result = 0;

    public static void getStr(char[] ch1, int i1, char[] ch2, int i2, String s) {
//        System.out.println(s);
        if (i1 == ch1.length && i2 == ch2.length) {
            boolean valid = isValid(s);
            if (valid) {
                result++;
            }
            return;
        }
//        if (i1 == ch1.length || i2 == ch2.length) {
//            return;
//        }
        if (i1 < 3) {
            getStr(ch1, i1 + 1, ch2, i2, s += ch1[i1]);
            s = s.substring(0, s.length() - 1);
        }
        if (i2 < 3) {
            getStr(ch1, i1, ch2, i2 + 1, s += ch2[i2]);
        }
//        s = s.substring(0, s.length() - 1);

    }


    public static boolean isValid(String s) {
        //1、申明一个stack
        if (s == null) {
            return false;
        }
        if (s == "") {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        //遍历s String本质上是char[]
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                //如果是(   压入栈中
                stack.push(c);
            } else {
                //  )   进行比对
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
            }
        }
        //如果循环结束,栈中没有元素则表示全部匹配成功
        return stack.isEmpty();
    }
}
