package jianzhioffer;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 18:48
 * @Description: 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个
 * 数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度
 * 为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class Duplicate {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null||length<=1){
            return false;
        }
        for(int i = 0;i<length;i++){
            int index = numbers[i]>=length?numbers[i]-length:numbers[i];
            if(numbers[index]>=length){
                duplication[0]=index;
                return true;
            }else{
                numbers[index]+=length;
            }
        }
        return false;
    }
}
