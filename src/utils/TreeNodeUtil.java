package utils;

import tree.TreeNode;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/22 14:30
 * @Description:
 */
public class TreeNodeUtil {
    public static TreeNode getTree() {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.left.left.left = new TreeNode(1);
        head.right.left = new TreeNode(7);
        head.right.left.left = new TreeNode(6);
        head.right.right = new TreeNode(10);
        head.right.right.left = new TreeNode(9);
        head.right.right.right = new TreeNode(11);

        return head;
    }
}
