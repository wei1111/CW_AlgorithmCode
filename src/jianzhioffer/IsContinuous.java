package jianzhioffer;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 18:28
 * @Description:
 */
public class IsContinuous {
    public boolean isContinuous(int [] numbers) {
        //排序写不好，使用max-min<=4
        if(numbers==null||numbers.length!=5){
            return false;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int flag = 0;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==0){
                continue;
            }else{
                if((flag&(1 << numbers[i]))!=0){
                    return false;
                }
                flag = flag|(1<<numbers[i]);
                min = Math.min(min,numbers[i]);
                max = Math.max(max,numbers[i]);
            }
        }
        return max-min<=4;
    }
}
