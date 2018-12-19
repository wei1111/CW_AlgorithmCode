package dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permute {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     * <p>
     * 15. 全排列
     * 给定一个数字列表，返回其所有可能的排列。
     * <p>
     * 样例
     * 给出一个列表[1,2,3]，其全排列为：
     * <p>
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     * 挑战
     * 使用递归和非递归分别解决。
     * <p>
     * 注意事项
     * 你可以假设没有重复数字。
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        if (nums.length == 0) {
            result.add(list);
            return result;
        }
        boolean[] color = new boolean[nums.length];//存放color节点
        for (int i = 0; i < nums.length; i++) {
            color[i] = false;
        }
        dfs(result, list, nums, color);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> list, int[] nums,
                    boolean[] color) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (color[i] == false) {
                list.add(nums[i]);
                color[i] = true;
                dfs(result, list, nums, color);
                color[i] = false;//回退到上一步后要将本位置的访问状态置回false
                list.remove(list.size() - 1);//将下面添加的剪掉
            }
        }
    }

    @Test
    public void testPermute() {
        List<List<Integer>> result = permute(new int[]{1, 2, 3, 4});
        Map<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).toString());
        }
    }

    @Test
    public void test() {
//        System.out.println(1 << 30);
//        System.out.println(1 << 31);
//        System.out.println(1 << 32);
//        System.out.println(Integer.MAX_VALUE);
//
//        Integer i1 = -2;
//        Integer i2 = 2;
//        System.out.println(Integer.toBinaryString(i1 >>> 32));
//        System.out.println(Integer.toBinaryString(i1 >>> 33));
//        System.out.println(Integer.toBinaryString(i1));
//        System.out.println(Integer.toBinaryString(i2 >>> 4));
//        System.out.println(Integer.toBinaryString(i2));
        String str = "1000000000000000000";
        int i = Integer.parseInt(str, 2);
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));

        int i1 = get(i);
        System.out.println(Integer.toBinaryString(i1));
    }

    public int get(int n) {
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n;
    }
}
