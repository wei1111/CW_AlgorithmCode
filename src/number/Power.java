package number;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/18 19:18
 * 1.全面考察指数的正负、底数是否为零等情况。
 * 2.写出指数的二进制表达，例如13表达为二进制1101。
 * 3.举例:10^1101 = 10^0001*10^0100*10^1000。
 * 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
 * 这里要注意的是0作为底数的时候指数不可以是负数，因为分母不可以为0
 */

public class Power {
    public double Power(double base, int n) throws Exception {
        double res = 1, curr = base;
        int exponent;
        if (n > 0) {
            exponent = n;
        } else if (n < 0) {
            if (base == 0) {
                throw new Exception("0作为底数的时候指数不可以是负数");
            }
            exponent = -n;
        } else {//0的0次方也是1
            return 1;
        }
        while (exponent != 0) {
            if ((exponent & 1) == 1) {
                res *= curr;
            }
            curr *= curr;
            exponent >>= 1;
        }
        return n > 0 ? res : 1 / res;
    }
}