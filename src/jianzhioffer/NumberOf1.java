package jianzhioffer;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 15:30
 * @Description: 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1 {
    public int numberOf1(int n) {
        int count = 0;
        while(n!=0){
            count+=1;
            n = n&(n-1);
        }return count;
    }
}
