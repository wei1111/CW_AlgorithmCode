package number;

import org.junit.Test;

/**
 * @author 12044
 */
public class AplusB {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: The sum of a and b
     * https://www.lintcode.com/problem/a-b-problem/description
     */

    /**
     * 描述
     * 给出两个整数 aa 和 bb , 求他们的和。
     * <p>
     * 你不需要从输入流读入数据，只需要根据aplusb的两个参数a和b，计算他们的和并返回就行。
     * <p>
     * 您在真实的面试中是否遇到过这个题？
     * 说明
     * a和b都是 32位 整数么？
     * <p>
     * 是的
     * 我可以使用位运算符么？
     * <p>
     * 当然可以
     * 样例
     * 如果 a=1 并且 b=2，返回3。
     * <p>
     * 挑战
     * 显然你可以直接 return a + b，但是你是否可以挑战一下不这样做？（不使用++等算数运算符）
     *
     * @param a
     * @param b
     * @return
     */
    @Test
    public int aplusb(int a, int b) {
        // write your code here
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        //没有进位的加法 101 + 111 = 0010 只有为(1,1),(0,0)为0 (1,0),(0,1)为1，所以使用异或
        int c = a ^ b;

        //有进位的加法 101 + 111 = 1100 仅仅计算带有进位的(1,1) 101 使用& 且左移一位 -> 1010，递归和第一步求和
        int d = a & b;
        d = d << 1;

        if (d != 0) {
            c = aplusb(c, d);
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(new AplusB().aplusb(-5, -7));
    }
}
