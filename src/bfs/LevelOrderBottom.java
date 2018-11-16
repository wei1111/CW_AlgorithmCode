package bfs;

import org.junit.Test;
import tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LevelOrderBottom {
    /**
     * @param root: A tree
     * @return: buttom-up level order a list of lists of integer
     *
     * 70. 二叉树的层次遍历 II
     * 给出一棵二叉树，返回其节点值从底向上的层次序遍历（按从叶节点所在层到根节点所在的层遍历，然后逐层从左往右遍历）
     *
     * 样例
     * 给出一棵二叉树 {3,9,20,#,#,15,7},
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 按照从下往上的层次遍历为：
     *
     * [
     *   [15,7],
     *   [9,20],
     *   [3]
     * ]
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        LinkedList<List<Integer>> results = new LinkedList<>();
        List<Integer> level = new LinkedList<>();
        LinkedList<TreeNode> currentLevelNode = new LinkedList<>();
        LinkedList<TreeNode> nextLevelNode = new LinkedList<>();
        if (root == null) {
            return results;
        }

        currentLevelNode.add(root);
        bfs(results, level, currentLevelNode, nextLevelNode);
        return results;
    }

    private void bfs(LinkedList<List<Integer>> results, List<Integer> level,
                     LinkedList<TreeNode> currentLevelNode, LinkedList<TreeNode> nextLevelNode) {
        if (currentLevelNode.size() == 0) {
            return;
        }
        while (currentLevelNode.size() != 0) {
            TreeNode treeNode = currentLevelNode.poll();
            level.add(treeNode.val);
            if (treeNode.left != null) {
                nextLevelNode.add(treeNode.left);
            }
            if (treeNode.right != null) {
                nextLevelNode.add((treeNode.right));
            }
        }
        results.addFirst(new LinkedList<>(level));
        level.clear();
        bfs(results, level, nextLevelNode, currentLevelNode);
    }

    @Test
    public void testLevelOrderBottom() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        List<List<Integer>> results = levelOrderBottom(treeNode1);
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i).toString());
        }
    }
}
