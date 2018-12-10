package dp;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/10 13:31
 * @Description: 最大子串是要找出由数组成的
 * 一维数组中和最大的连续子序列。比如{5,-3,4,2}
 * 的最大子串就是 {5,-3,4,2}，它的和是8,达到
 * 最大；而 {5,-6,4,2}的最大子串是{4,2}，它的
 * 和是6。
 */
public class MaxSubSum {
    class ResultType {
        int start;
        int end;

        public ResultType() {
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public ResultType(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int maxSubSum(int[] arr, HashMap<Integer, ResultType> map) {
        int max = 0;
        ResultType resultType = new ResultType();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                if (sum == 0) {
                    resultType.start = i;
                }
                sum += arr[i];
                max = max > sum ? max : sum;
            } else {
                if (sum >= max) {
                    resultType.end = i - 1;
                    map.put(max, new ResultType(resultType.start, resultType.end));
                }
                sum = 0;
            }
        }

        if (!map.containsKey(max)) {
            map.put(max, new ResultType(resultType.start, arr.length - 1));
        }
        return max;
    }

    @Test
    public void test() {
        HashMap<Integer, ResultType> map = new HashMap<>();
        int[] arr = {5, -6, 4, 2, 0, -1, 3, -5};
        int result = maxSubSum(arr, map);
        System.out.println(result);
        ResultType resultType = map.get(result);

        for (int i = resultType.start; i <= resultType.end; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
