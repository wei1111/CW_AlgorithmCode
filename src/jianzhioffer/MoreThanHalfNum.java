package jianzhioffer;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 15:46
 * @Description: 数组中有一个数字出现的次数超过数组长度的一半，
 * 请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum {
    //这题的解法很巧妙
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int sum = 1;
        int num = array[0];
        for(int x = 1;x<array.length;x++){
            if(array[x]==num){
                sum++;
            }else{
                sum--;
                if(sum==0){
                    num = array[x];
                    sum = 1;
                }
            }
        }
        if(sum>1){
            return num;
        }else if(sum ==1 ){
            int time = 0;
            for(int x = 0;x<array.length;x++){
                if(array[x]==num){
                    time++;
                }
            }
            if(time>array.length/2){
                return num;
            }return 0;
        }else{
            return 0;
        }
    }
}
