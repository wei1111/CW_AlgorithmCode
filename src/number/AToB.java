package number;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/7 18:35
 * @Description: 一个数只能减一或者乘二，从一个数变为另一个数的最小操作次数
 * 输入：4  5   输出：3
 * <p>
 * 输入：5  12   输出：4
 * <p>
 * 输入：5  14  输出：4
 * <p>
 * 输入：4  6   输出：2
 */
public class AToB {
    public static int aToB(int a, int b) {
        if (a >= b) {
            return b - a;
        }
        int count = 0;
        while (a < b) {
            if (b % 2 == 0) {
                b /= 2;
                count++;
            } else {
                b += 1;
                b /= 2;
                count += 2;
            }
        }
        count += a - b;
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        aToB(4, 5);
        aToB(5, 12);
    }
}
