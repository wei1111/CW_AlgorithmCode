package jianzhioffer;

import tree.TreeNode;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 18:22
 * @Description: 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class IsBalanced {
    //简单的树型dp
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalanced(root).isBalancedTree;
    }

    private static class ReturnData {
        private int gaodu;
        private boolean isBalancedTree;

        public ReturnData(int gaodu, boolean isBalancedTree) {
            this.gaodu = gaodu;
            this.isBalancedTree = isBalancedTree;
        }
    }

    public ReturnData isBalanced(TreeNode head) {
        if (head == null) {
            return new ReturnData(0, true);
        }

        ReturnData leftData = isBalanced(head.left);
        if (!leftData.isBalancedTree) {
            return new ReturnData(0, false);
        }
        ReturnData rightData = isBalanced(head.right);
        if (!rightData.isBalancedTree) {
            return new ReturnData(0, false);
        }

        if (Math.abs(rightData.gaodu - leftData.gaodu) > 1) {
            return new ReturnData(0, false);
        }

        return new ReturnData(Math.max(rightData.gaodu, leftData.gaodu) + 1, true);
    }
}
