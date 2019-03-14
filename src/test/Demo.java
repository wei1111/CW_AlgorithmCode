package test;

import java.util.ArrayList;

/**
 * @Author: wei1
 * @Date: Create in 2019/1/31 23:34
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String randomStr =
                    (int) (Math.random() * 10000) + "" + (int) (Math.random() * 1000000000);
//            String randomStr = "11";
            System.out.println(randomStr);
            cutStr(randomStr);
        }
    }

    //用5个分割符去切分字符串，每个字符串代表的数字要小于350，也可以为长度为0的字符串
    public static void cutStr(String str) {
        if (str == null) {
            return;
        }
        if (isNotNum(str)) {
            return;
        }

        dfs(str, 5, new ArrayList<String>(6));
    }

    private static boolean isNotNum(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int x = chars[i] - '0';

            if (x < 0 || x > 9) {
                return true;
            }
        }
        return false;
    }

    private static void dfs(String str, int i, ArrayList<String> temp) {
        if (str.length() > (i + 1) * 3) {
            return;
        }
        if (i == -1 && temp.size() == 6) {
            System.out.println(temp);
            return;
        }
        //下一个分割的字符串长度为0
        for (int j = 0; j <= 3; j++) {
            if (str.length() < j) {
                return;
            }
            String substring = str.substring(0, j);
            int num = 0;
            if (j != 0) {
                num = Integer.parseInt(substring);
                if (num < 350) {
                    temp.add(substring);
                    dfs(str.substring(j), i - 1, temp);
                    temp.remove(temp.size() - 1);
                }
            } else {
                temp.add(" ");
                dfs(str.substring(j), i - 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

}
