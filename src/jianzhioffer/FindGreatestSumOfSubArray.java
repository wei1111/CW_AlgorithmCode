package jianzhioffer;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 15:48
 * @Description: 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8
 * (从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和，
 * (子向量的长度至少是1)
 */
public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array==null){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0;i<array.length;i++){
            //这里很巧妙的解决了全市负数的情况
            sum = Math.max(sum+array[i],array[i]);
            max = Math.max(max,sum);
        }
        return max;
    }
}
