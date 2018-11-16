package dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class permuteUnique {
    /**
     * @param : A list of integers
     * @return: A list of unique permutations
     * <p>
     * 16. 带重复元素的排列
     * 给出一个具有重复数字的列表，找出列表所有不同的排列。
     * <p>
     * 样例
     * 给出列表 [1,2,2]，不同的排列有：
     * <p>
     * [
     * [1,2,2],
     * [2,1,2],
     * [2,2,1]
     * ]
     * 挑战
     * 使用递归和非递归分别完成该题。
     * <p>
     * 写过不含重复元素的全排列，这提是含重复元素的，应该相差不大
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        HashSet<List<Integer>> hashResult = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        if (nums.length == 0) {
            result.add(list);
            return result;
        }
        boolean[] color = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            color[i] = false;
        }
        dfs(hashResult, list, nums, color);
        result = new ArrayList<>(hashResult);
        return result;
    }


    public void dfs(HashSet<List<Integer>> hashResult, List<Integer> list, int[] nums, boolean[] color) {
        if (list.size() == nums.length) {
            hashResult.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (color[i] == false) {
                list.add(nums[i]);
                color[i] = true;
                dfs(hashResult, list, nums, color);
                color[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    /**答案
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }

        Arrays.sort(nums);
        dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), results);

        return results;
    }


      private void dfs(int[] nums,
                     boolean[] visited,
                     List<Integer> permutation,
                     List<List<Integer>> results) {
        if (nums.length == permutation.size()) {
            results.add(new ArrayList<Integer>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, permutation, results);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }
     */

    @Test
    public void testPermuteUnique() {
//        List<List<Integer>> result = permuteUnique(new int[]{1, 2, 2});
//        for (int i = 0; i < result.size(); i++) {
//            System.out.println(result.get(i).toString());
//        }
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(1);

        System.out.println(list1.hashCode());
        System.out.println(list2.hashCode());
        System.out.println(list3.hashCode());
        System.out.println(list1==list2);
        System.out.println(list1==list3);
        System.out.println(list2==list3);
        System.out.println(list1.equals(list2));
        System.out.println(list1.equals(list3));
        System.out.println(list2.equals(list3));

    }
}
