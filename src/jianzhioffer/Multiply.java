package jianzhioffer;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 18:49
 * @Description: 给定一个数组A[0, 1, ..., n-1],
 * 请构建一个数组B[0,1,...,n-1],其中B中的元素
 * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Multiply {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        int len = A.length;
        int[] result = new int[len];
        result[0] = 1;
        //计算三角形的下半部分
        for (int i = 1; i < len; i++) {
            result[i] = result[i - 1] * A[i - 1];
        }
        //计算三角形的上半部分,为了dp所以是从下算到上的
        int temp = 1;
        for (int i = len - 2; i >= 0; i--) {
            temp *= A[i + 1];
            result[i] *= temp;
        }
        return result;
    }
}
