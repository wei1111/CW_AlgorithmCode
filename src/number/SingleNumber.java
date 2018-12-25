package number;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/22 1:48
 * @Description: Given an array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 *  1.异或满足交换律。
 *  2.相同两个数异或为0。
 *  3.0异或一个数为那个数本身。
 *  所以所有的偶数个中找基数个可以使用这种方式
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            result ^= A[i];
        }
        return result;
    }
}
