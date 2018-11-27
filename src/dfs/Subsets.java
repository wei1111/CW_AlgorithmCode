package dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     *
     * 17. 子集
     * 给定一个含不同整数的集合，返回其所有的子集
     *
     * 样例
     * 如果 S = [1,2,3]，有如下的解：
     *
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     * 挑战
     * 你可以同时用递归与非递归的方式解决么？
     *
     * 注意事项
     * 子集中的元素排列必须是非降序的，解集必须不包含重复的子集
     */

    /**
     * 求子集问题是经典的NP问题，复杂度上我们就无法强求了哈，肯定是非多项式量级的。
     * 一般来说这个问题有两种解法：递归和非递归。
     * 我们先来说说递归解法，主要递推关系就是假设函数返回递归集合，现在加入一个新的数字，
     * 我们如何得到包含新数字的所有子集。其实就是在原有的集合中对每集合中的每个元素都加
     * 入新元素得到子集，然后放入原有集合中（原来的集合中的元素不用删除，因为他们也是合
     * 法子集）。而结束条件就是如果没有元素就返回空集（注意空集不是null，而是没有元素的
     * 数组）就可以了。时间和空间都是取决于结果的数量，也就是O(2^n)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
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
        helper2(list, nums, startIndex, results);
//        helper1(results, list, nums);
        return results;
    }

    //非递归
    private void helper1(List<List<Integer>> results, List<Integer> list, int[] nums) {
        if (results.size() == 0) {
            results.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            int num = results.size();
            for (int j = 0; j < num; j++) {
                List<Integer> list2 = new ArrayList<>(results.get(j));
                list2.add(nums[i]);
                results.add(list2);
            }
        }
    }

    //递归 DFS
    // 递归三要素
    // 1. 递归的定义：在 Nums 中找到所有以 subset 开头的的集合，并放到 results
    private void helper2(List<Integer> subset,
                         int[] nums,
                         int startIndex,
                         List<List<Integer>> results) {
        // 2. 递归的拆解
        // deep copy
        // results.add(subset);
        results.add(new ArrayList<>(subset));

        for (int i = startIndex; i < nums.length; i++) {
            // [1] -> [1,2]
            subset.add(nums[i]);
//            System.out.println("+:"+subset.toString());

            // 寻找所有以 [1,2] 开头的集合，并扔到 results
            helper2(subset, nums, i + 1, results);
            // [1,2] -> [1]  回溯
            subset.remove(subset.size() - 1);
//            System.out.println("-:"+subset.toString());

        }

        // 3. 递归的出口
        // return;
    }


    public List<List<Integer>> subsets2(int[] nums) {
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

        dfs(nums, results, list, 0);
        return results;
    }

    private void dfs(int[] nums, List<List<Integer>> results, List<Integer> list, int i) {
        if (i == nums.length) {
            results.add(list);
            return;
        }
        dfs(nums, results, new ArrayList<>(list), i + 1);
        list.add(nums[i]);
        dfs(nums, results, new ArrayList<>(list), i + 1);
    }

    @Test
    public void testSubsets() {
        List<List<Integer>> results = subsets(new int[]{1, 2, 3, 4});
        for (int i = 0; i < results.size(); i++) {
            System.out.println(i + ":" + results.get(i).toString());
        }

        System.out.println("====================");
        List<List<Integer>> results2 = subsets2(new int[]{1, 2, 3, 4});
        for (int i = 0; i < results2.size(); i++) {
            System.out.println(i + ":" +  results2.get(i).toString());
        }
    }
}
