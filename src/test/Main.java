package test;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2019/3/7 19:54
 * @Description:
 */
public class Main {
    public static void main(String[] args) {

    }

    public String appendStr(String string) {
        string += "bbb";
        return string;
    }

    @Test
    public void test() {
        String str = "aaa";
        System.out.println(str);
        System.out.println(appendStr(str));
    }
}
