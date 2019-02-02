package tree;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/2 20:05
 * @Description: 最近公共父节点
 */
public class LowestCommonAncestor {
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        root.right.left = six;
        TreeNode p = new TreeNode(4);
        TreeNode q = new TreeNode(5);
        root.left.left = p;
        root.left.right = q;

        TreeNode treeNode = lowestCommonAncestor(root, p, six);
        System.out.println(treeNode.val);

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode leftN = lowestCommonAncestor(root.left, p, q);
        TreeNode rightN = lowestCommonAncestor(root.right, p, q);
        if (leftN != null && rightN != null) {
            return root;
        }
        if (leftN == null) {
            return rightN;
        }
        return leftN;
    }
}
