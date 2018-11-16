package jzoffer;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/9 19:28
 * @Description:
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项
 * （从0开始，第0项为0）。
 * n<=39
 */
public class Fibonacci {
    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public int fibonacci2(int n) {
        int a=0 ,c =0;
        int b=1;
        if (n == 0) {
            return a;
        }
        if (n == 1) {
            return b;
        }

        while (n > 1) {
            c = a + b;
            a = b;
            b = c;
            n--;
        }
        return c;
    }

    @Test
    public void test() {
        System.out.println(fibonacci(30));
        System.out.println(fibonacci2(30));
    }
}
