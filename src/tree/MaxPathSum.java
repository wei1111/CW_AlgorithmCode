package tree;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/23 22:52
 * @Description:
 */
public class MaxPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxPS(root);
        return max;
    }

    private int maxPS(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int leftReturn = maxPS(root.left);
        leftReturn = leftReturn > 0 ? leftReturn : 0;
        int rightReturn = maxPS(root.right);
        rightReturn = rightReturn > 0 ? rightReturn : 0;
        max = Math.max(leftReturn + rightReturn + root.val, max);
        return Math.max(leftReturn, rightReturn) + root.val;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);
        System.out.println(maxPathSum(root));
    }
}
