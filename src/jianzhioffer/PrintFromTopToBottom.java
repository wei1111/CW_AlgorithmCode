package jianzhioffer;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 15:41
 * @Description: 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintFromTopToBottom {
    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            result.add(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        return result;
    }
}
