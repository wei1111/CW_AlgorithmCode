package jianzhioffer;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 18:24
 * @Description: 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。
 * 请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int res = 0;
        for(int i = 0;i<array.length;i++){
            res ^= array[i];
        }
        //得到第一次出现1的bit位
        int index = 0;
        while((res&1) == 0){
            res = res>>1;
            index++;
        }
        for(int i = 0;i<array.length;i++){
            if(((array[i]>>index)&1) == 0){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }
}
