package jianzhioffer;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 18:46
 * @Description: 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 不用加法求和
 */
public class Add {
    public int Add(int num1,int num2) {
        int n = (num1&num2)<<1;
        int m = (num1^num2);
        if(n==0){
            return num1|num2;
        }else{
            return Add(n,m);
        }
    }
}
