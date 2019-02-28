package jianzhioffer;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Author: wei1
 * @Date: Create in 2019/1/9 23:42
 * @Description: 找出所有和为S的连续正数序列
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        int s = 0;
        int ladder = 1;
        int former = 1;
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        ArrayList<Integer> temp = new ArrayList();
//        while (ladder <= sum) {
        while (former <= sum) {
            if (s < sum) {
                s += former;
                temp.add(former);
                former++;
            } else if (s > sum) {
                s -= ladder;
                temp.remove(new Integer(ladder));
                ladder++;
            } else {
                result.add(new ArrayList(temp));
                s += former;
                temp.add(former);
                former++;
            }
        }
        return result;
    }

    @Test
    public void test() {
        ArrayList<ArrayList<Integer>> arrayLists = findContinuousSequence(3);
        for (ArrayList<Integer> arrayList : arrayLists) {
            System.out.println(arrayList);
        }
    }
}
