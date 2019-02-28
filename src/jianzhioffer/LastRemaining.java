package jianzhioffer;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 18:28
 * @Description: 约瑟夫环问题
 */
public class LastRemaining {
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        } else {
            return (LastRemaining_Solution(n - 1, m) + m) % n;
        }
    }
}
