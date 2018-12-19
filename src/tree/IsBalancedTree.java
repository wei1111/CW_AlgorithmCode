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
            return new ReturnData(0, false);
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

        return new ReturnData(Math.abs(rightData.gaodu - leftData.gaodu) + 1, true);
    }

    @Test
    public void test() {
        TreeNode head = TreeNodeUtil.getTree();
        ReturnData balanced = isBalanced(head);
        System.out.println(balanced.isBalancedTree+" : "+ balanced.gaodu);
    }
}
