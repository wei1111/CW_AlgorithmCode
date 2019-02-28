package tree;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/25 11:17
 * @Description:
 */

public class Solution {

    TreeNode solution(TreeNode root, TreeNode left, TreeNode right) {
        // 求最大的公共父节点
        if (root == null || root.val == left.val || root.val == right.val) {
            return root;
        }
        TreeNode rootL = solution(root.left, left, right);
        TreeNode rootR = solution(root.right, left, right);
        if (rootL != null && rootR != null) {
            return root;
        }
        if (rootL == null) {
            return rootR;
        } else {
            return rootL;
        }
    }

}
