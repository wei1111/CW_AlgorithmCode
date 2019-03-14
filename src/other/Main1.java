package other;

import java.util.Stack;

public class Main1 {
    public static void main(String[] args) {
        String str = "dajsdglajg,sagadgs,asf";
        String reverse = reverse(str);
        System.out.println(reverse);
    }

    public static String reverse(String str) {
        if (str == null || str.equals("")) {
            return str;
        }

        String[] strs = str.split(",");
        String result = "";
        for (String s : strs) {
            result += rever(s);
            result += ",";
        }
        result = result.substring(0, result.length() - 1);
        return result;
    }

    public static String rever(String str) {
        char[] chs = str.toCharArray();
        Stack<Character> stack = new Stack();
        StringBuilder sb = new StringBuilder();
        for (char ch : chs) {
            stack.push(ch);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
