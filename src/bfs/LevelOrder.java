package bfs;

import org.junit.Test;
import org.testng.annotations.Test;
import tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LevelOrder {
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     * <p>
     * 69. 二叉树的层次遍历
     * 给出一棵二叉树，返回其节点值的层次遍历（逐层从左往右访问）
     * <p>
     * 样例
     * 给一棵二叉树 {3,9,20,#,#,15,7} ：
     * <p>
     * 3
     * / \
     * 9  20
     *   /  \
     *  15   7
     * 返回他的分层遍历结果：
     * <p>
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     * 挑战
     * 挑战1：只使用一个队列去实现它
     * <p>
     * 挑战2：用DFS算法来做
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> results = new LinkedList<>();
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

    private void bfs(List<List<Integer>> results, List<Integer> level,
                     LinkedList<TreeNode> currentLevelNode, LinkedList<TreeNode> nextLevelNode) {
        if (currentLevelNode.size() == 0) {
            return;
        }
        while (currentLevelNode.size() != 0) {
            TreeNode treeNode = currentLevelNode.poll();
//            System.out.println(treeNode.val);
            level.add(treeNode.val);
            if (treeNode.left != null) {
                nextLevelNode.add(treeNode.left);
            }
            if (treeNode.right != null) {
                nextLevelNode.add((treeNode.right));
            }
        }
        results.add(new LinkedList<>(level));
        level.clear();
        bfs(results, level, nextLevelNode, currentLevelNode);
    }

    @Test
    public void testLevelOrder() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        List<List<Integer>> results = levelOrder(treeNode1);
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i).toString());
        }
    }
}
