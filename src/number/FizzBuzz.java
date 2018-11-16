package number;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FizzBuzz {
    /**
     * @param n: An integer
     * @return: A list of strings.
     */

    /**
     * Fizz Buzz 问题
     * 给你一个整数n. 从 1 到 n 按照下面的规则打印每个数：
     * <p>
     * 如果这个数被3整除，打印fizz.
     * 如果这个数被5整除，打印buzz.
     * 如果这个数能同时被3和5整除，打印fizz buzz.
     * 样例
     * 比如 n = 15, 返回一个字符串数组：
     * <p>
     * [
     * "1", "2", "fizz",
     * "4", "buzz", "fizz",
     * "7", "8", "fizz",
     * "buzz", "11", "fizz",
     * "13", "14", "fizz buzz"
     * ]
     * 挑战  -这是啥挑战啊，一个if有什么用？？？垃圾
     * Can you do it with only one if statement?
     */
    public List<String> fizzBuzz(int n) {
        // write your code here
        String[] strings = new String[n];
        for (int i = 1; i <= n; i++) {
            strings[i - 1] = "" + i;
            if (i % 15 == 0) {

                strings[i - 1] = "fizz buzz";
            }else if (i % 3 == 0) {
                strings[i - 1] = "fizz";
            }
            else if (i % 5 == 0) {
                strings[i - 1] = "buzz";
            }
        }
        return Arrays.asList(strings);
    }

    @Test
    public void testFizzBuzz() {
        System.out.println(fizzBuzz(15).toString());
    }
}
