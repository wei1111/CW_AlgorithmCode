package jzoffer;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/9 19:42
 * @Description: 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloorII {
    public int jumpFloorII(int target) {
        int a = 1;
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            return a << target - 1;
        }
    }

    @Test
    public void test() {
        System.out.println(jumpFloorII(10));
    }
}
