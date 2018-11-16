package dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     * <p>
     * 18. 子集 II
     * 给定一个可能具有重复数字的列表，返回其所有可能的子集
     * <p>
     * 样例
     * 如果 S = [1,2,2]，一个可能的答案为：
     * <p>
     * [
     * [2],
     * [1],
     * [1,2,2],
     * [2,2],
     * [1,2],
     * []
     * ]
     * 挑战
     * 你可以同时用递归与非递归的方式解决么？
     * <p>
     * 注意事项
     * 子集中的每个元素都是非降序的
     * 两个子集间的顺序是无关紧要的
     * 解集中不能包含重复子集
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        if (nums.length == 0) {
            results.add(list);
            return results;
        }
        Arrays.sort(nums);
        int startIndex = 0;
//        helper(results,list,nums);
        dfs(list, nums, startIndex, results);
        return results;
    }

    //非递归
    private void helper(List<List<Integer>> results, List<Integer> list, int[] nums) {
        if (results.size() == 0) {
            results.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
//            if ( i>= 1 && nums[i] == nums[i - 1]) {
//                continue;
//            }
            int num = results.size();
            for (int j = 0; j < num; j++) {
                List<Integer> list2 = new ArrayList<>(results.get(j));
                list2.add(nums[i]);
                results.add(list2);
            }
        }
    }

    private void dfs(List<Integer> subset, int[] nums, int startIndex, List<List<Integer>>
            results) {
        results.add(new ArrayList<>(subset));
        System.out.println("startIndex-->"+(startIndex+1)+"subset-->"+subset.toString());
        for (int i = startIndex; i < nums.length; i++) {
            if (i!=startIndex&&nums[i]==nums[i-1]){
                continue;
            }
            subset.add(nums[i]);
//            System.out.println("iiiiiiiiii------->"+(i+1));
            dfs(subset, nums, i + 1, results);
            subset.remove(subset.size() - 1);
        }
        // 递归的出口
        // return;
    }

    @Test
    public void testSubsetsWithDup() {
        List<List<Integer>> results = subsetsWithDup(new int[]{1, 1, 2, 3, 4});
        for (int i = 0; i < results.size(); i++) {
//            System.out.println(results.get(i).toString());
        }
    }
}
