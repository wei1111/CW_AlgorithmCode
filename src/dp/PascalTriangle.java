package dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/24 0:48
 * @Description: 这个DP难在使用O(K)的空间复杂度，从后往前覆盖dp数组，使得二位的dp数组通过覆盖达到一维
 * Given an index k, return the k th row of the Pascal's triangle.
 * <p>
 * For example, given k = 3,
 * Return[1,3,3,1].
 * <p>
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalTriangle {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<>();
        if (rowIndex < 0) {
            return result;
        }
        result.add(1);
        //这里从1开始，因为第一层已经放进去了就是1
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j - 1) + result.get(j));
            }
            //每次覆盖了前面的dp数组后需要往本层末尾加一个1
            result.add(1);
        }
        return result;
    }

    @Test
    public void test() {
        ArrayList<Integer> row = getRow(1);
        System.out.println(Arrays.toString(row.toArray()));
    }
}
