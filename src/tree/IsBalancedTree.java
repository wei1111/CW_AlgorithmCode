package tree;

import org.junit.Test;
import utils.TreeNodeUtil;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/22 14:13
 * @Description:
 */
public class IsBalancedTree {
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

    @Test
    public void test() {
        TreeNode head = TreeNodeUtil.getTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(1);
        root.left.left.left = new TreeNode(1);
        root.left.left.left.right = new TreeNode(1);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(1);

//        ReturnData balanced = isBalanced(head);
        ReturnData balanced = isBalanced(root);
        System.out.println(balanced.isBalancedTree + " : " + balanced.gaodu);
    }
}
