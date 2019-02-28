package jianzhioffer;

import java.util.ArrayList;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 18:17
 * @Description: 丑数
 */
public class GetUglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        //add进第一个丑数1
        list.add(1);
        //三个下标用于记录丑数的位置
        int i2 = 0, i3 = 0, i5 = 0;
        while (list.size() < index) {
            //三个数都是可能的丑数，取最小的放进丑数数组里面
            int n2 = list.get(i2) * 2;
            int n3 = list.get(i3) * 3;
            int n5 = list.get(i5) * 5;
            int min = Math.min(n2, Math.min(n3, n5));
            list.add(min);
            if (min == n2) {
                i2++;
            }
            if (min == n3) {
                i3++;
            }
            if (min == n5) {
                i5++;
            }
        }
        return list.get(list.size() - 1);
    }
}
