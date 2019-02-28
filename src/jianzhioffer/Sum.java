package jianzhioffer;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 18:46
 * @Description: 求1+2+3+...+n，要求不能使用乘除法、
 * for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Sum {
    public int Sum_Solution(int n) {
        int result = n;
        boolean b = (n>0)&&((result += Sum_Solution(n-1))>0);
        return result;
    }
}
