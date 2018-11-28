package number;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/27 14:15
 * @Description: 母牛每年生一只母牛， 新出生的母牛成长三年后也能每年生一只
 * 母牛， 假设不会死。 求N年后， 母牛的数量。这个和🐸那题差不多
 * f(n) = f(n-1)+f(n-3)
 */
public class Cow {
    public int cowNums(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        return cowNums(n - 1) + cowNums(n - 3) - cowNums(n - 10);
    }

    public int cowNums2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        int res = 3;
        int pre = 2;
        int prepre = 1;
        int tmp1 = 0;
        int tmp2 = 0;
        for (int i = 4; i <= n; i++) {
            tmp1 = res;
            tmp2 = pre;
            res = res + prepre;
            pre = tmp1;
            prepre = tmp2;
        }
        return res;
    }

    @Test
    public void test() {
        //1 2 3
        System.out.println(cowNums(11));
        System.out.println(cowNums2(20));
        System.out.println(cowNums2(10));

    }
}
