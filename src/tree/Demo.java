package tree;

import java.util.Stack;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/19 0:44
 * @Description:
 */
public class Demo {
    public static void preOrderUnRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.println("demo.preOrderUnRecur-->");
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.print(pop.val+" ");
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }


    public static void inOrderUnRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.add(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.val+" ");
                head = head.right;
            }
        }
    }

    public static void postOrderUnRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            stack2.push(pop);
//            System.out.println(pop.val);
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " ");
        }
    }
}
