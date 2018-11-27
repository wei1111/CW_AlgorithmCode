package tree;

import org.junit.Test;
import utils.TreeNodeUtil;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/22 15:25
 * @Description: 判断是不是二叉搜索树
 * 当前节点为null就弹出来，往右移
 */
public class IsBSTAndCBT {
    public static boolean isBST(TreeNode head) {
        if (head == null) {
            //空树也是的
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.add(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.val + " ");
                if (min < head.val) {
                    min = head.val;
                } else {
                    return false;
                }
                head = head.right;
            }
        }
        return true;
    }

    public static boolean isCBT(TreeNode head) {
        if (head == null) {
            //空树也是完全二叉树
            return true;
        }
        boolean leaf = false;
        //层次遍历使用queue
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.push(head);
        while (!linkedList.isEmpty()) {
            head = linkedList.poll();
            System.out.print(head.val+" ");
            if ((head.left == null && head.right != null) ||
                    leaf && (head.left != null || head.right != null)) {
                return false;
            }
            //在这里要记住push和offer、add的区别
            if (head.left != null) {
                linkedList.offer(head.left);
            }
            if (head.right != null) {
                linkedList.offer(head.right);
            } else {
                leaf = true;
            }
        }
        return true;
    }


    @Test
    public void test() {
        TreeNode head = TreeNodeUtil.getTree();
        System.out.println(isBST(head));
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(2);
        head.right = new TreeNode(6);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(3);
        head.right.left = new TreeNode(5);

        PrintBinaryTree.printTree(head);
        System.out.println(isBST(head));
        System.out.println(isCBT(head));

    }
}
