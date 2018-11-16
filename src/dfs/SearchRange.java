package dfs;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SearchRange {
    /**
     * 11. Search Range in Binary Search Tree
     * @param root: param root: The root of the binary search tree
     * @param k1:   An integer
     * @param k2:   An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     * <p>
     * Search Range in Binary Search Tree
     * Given a binary search tree and a range [k1, k2], return all elements in the given range.
     * <p>
     * 样例
     * 如果有 k1 = 10 和 k2 = 22, 你的程序应该返回 [12, 20, 22].
     * <p>
     *     {20,1,40,#,#,35}
     *     20
     *  1    40
     *     35
     *            1
     *          /  \
     *        2     3
     *      / \   / \
     *    4   5  6   7
     *   /
     * 8
     */

    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        inOrderTraverse(root, k1, k2, list);
        return list;
    }

    public void inOrderTraverse(TreeNode root, int k1, int k2, List<Integer> list) {
        if (root != null) {
            if (root.left != null) {
                inOrderTraverse(root.left, k1, k2, list);
            }
            if (root.val >= k1 && root.val <= k2) {
                list.add(root.val);
            }
            if (root.right != null) {
                inOrderTraverse(root.right, k1, k2, list);
            }
        }
    }
}
