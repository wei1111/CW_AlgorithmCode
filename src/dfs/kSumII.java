package dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class kSumII {
    /**
     * @param A: an integer array
     * @param k: a postive integer <= length(A)
     * @paramtarget: an integer
     * @return: A list of lists of integer
     * <p>
     * 90. k数和 II
     * Given n unique integers, number k (1<=k<=n) and target.
     * <p>
     * Find all possible k integers where their sum is target.
     * <p>
     * 样例
     * 给出[1,2,3,4]，k=2， target=5，返回 [[1,4],[2,3]]
     */
    public List<List<Integer>> kSumII(int[] A, int k, int targer) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (A == null) {
            return result;
        }
        if (A.length == 0) {
            result.add(list);
            return result;
        }
        boolean[] color = new boolean[A.length];
        for (int i = 0; i < A.length; i++) {
            color[i] = false;
        }
        //先对数组进行排序方便后续运算
        Arrays.sort(A);
        int beginNum = A[0];
        //这里添加一个beginNum是的结果是升序，去除重复
        dfsSum(result, list, color, A, k, targer, beginNum);
        return result;
    }

    private void dfsSum(List<List<Integer>> result, List<Integer> list, boolean[] color, int[] a,
                        int k, int targer, int beginNum) {
        if (list.size() == k) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (beginNum <= a[i] && color[i] == false && (sumList(list) + a[i]) <= targer &&
                    list.size() < k) {
                if (list.size() < k - 1) {
                    list.add(a[i]);
                    color[i] = true;
                    dfsSum(result, list, color, a, k, targer, list.get(list.size() - 1));
                    //重置为上一个状态
                    list.remove(list.size() - 1);
                    color[i] = false;
                } else if (list.size() == k - 1 && (sumList(list) + a[i]) == targer) {
                    list.add(a[i]);
                    color[i] = true;
                    dfsSum(result, list, color, a, k, targer, list.get(list.size() - 1));
                    //重置为上一个状态
                    list.remove(list.size() - 1);
                    color[i] = false;
                }
            }
        }
    }

    public int sumList(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    @Test
    public void testkSumII() {
        // 给出[1,2,3,4]，k=2， target=5，返回 [[1,4],[2,3]]
        int[] nums = {1, 4, 7, 10, 12, 15, 16, 18, 21, 23, 24, 25, 26, 29};
        List<List<Integer>> result = kSumII(nums, 5, 113);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).toString());
        }
    }
}
