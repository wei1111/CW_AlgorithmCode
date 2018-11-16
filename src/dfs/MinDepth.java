package dfs;

import tree.TreeNode;

public class MinDepth {
    /**
     * @param root: The root of binary tree
     * @return: An integer
     *
     * 155. 二叉树的最小深度
     * 给定一个二叉树，找出其最小深度。
     *
     * 二叉树的最小深度为根节点到最近叶子节点的距离。
     * 样例
     * 给出一棵如下的二叉树:
     *
     *         1
     *
     *      /     \
     *
     *    2       3
     *
     *           /    \
     */

    /**
     * 同二叉树的最大深度不同
     * 如果是求最大深度，就两种情况
     * root==null, return 0
     * root !=null, return 1+Math.max(root.left, root.right);
     * 二叉树的最小深度
     * 需要设立递归的辅助函数,分三种情况
     * root = null, return Integer.MAX_VALUE
     * root.left==null && root.right==null, return 1
     * return 1 + Math.min(left, right)
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = dfsMinDepth(root);
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public int dfsMinDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            // 例如 一个节点，左子树是null，右子树还有东西，左子树就会
            // return最大整数这样不影响计算最小depth
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.min(dfsMinDepth(root.left), dfsMinDepth(root.right));
    }
}