package jianzhioffer;

import java.util.ArrayList;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 18:26
 * @Description: 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> temp = new ArrayList();

        if(array==null||array.length<=1){
            return temp;
        }
        int len = array.length;
        int ladder = 0;
        int former = len-1;
        int s = array[ladder]+array[former];
        while (ladder < former) {
            if (s < sum) {
                s -= array[ladder];
                s += array[++ladder];
            } else if (s > sum) {
                s -= array[former];
                s += array[--former];
            } else {
                temp.add(array[ladder]);
                temp.add(array[former]);
                return temp;
            }
        }
        return temp;
    }
}
