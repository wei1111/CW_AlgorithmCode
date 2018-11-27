package dfs;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/23 19:17
 * @Description:
 */
public class PrintAllStringSub {
    public void printAllStringSub(String str, int i, String result) {
        if (i == str.length() + 1) {
            System.out.println(result);
            return;
        }
        printAllStringSub(str, i + 1, result);
        printAllStringSub(str, i + 1, result + str.substring(i - 1, i));
    }

    @Test
    public void test() {
        printAllStringSub("chen", 1, "");
    }
}
