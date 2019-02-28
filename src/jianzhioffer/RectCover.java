package jianzhioffer;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 15:26
 * @Description: 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class RectCover {
    public int rectCover(int target) {
        if (target < 1) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int t1 = 1;
        int t2 = 2;
        int result = 0;
        while (target >= 3) {
            result = t1 + t2;
            t1 = t2;
            t2 = result;
            target--;
        }
        return result;
    }
}
