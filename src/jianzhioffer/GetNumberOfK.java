package jianzhioffer;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 18:21
 * @Description: 两边分别二分 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        //又是这题
        if(array==null||array.length==0){
            return 0;
        }
        //这里使用boolean来控制找左边边界还是右边边界
        boolean right = true;
        boolean left = false;
        return get(array,k,right)==-1?0:get(array,k,right) - get(array,k,left) + 1;
    }

    public int get(int[]array,int k,boolean isRight){
        int start = 0;
        int end = array.length-1;

        //get right
        while(start<=end){
            int mid = start+((end-start)>>1);
            if(array[mid]>k){
                end = mid - 1;
            }else if(array[mid]<k){
                start = mid + 1;
            }else if(!isRight&&mid-1>=start&&array[mid-1]==k){
                end = mid - 1;
            }else if(isRight&&mid+1<=end&&array[mid+1]==k){
                start = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
