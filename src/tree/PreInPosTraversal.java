package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/21 21:43
 * @Description:
 */
public class PreInPosTraversal {

    // 二叉树前序遍历
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null) {
            return arrayList;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            arrayList.add(pop.val);
            if (pop.right != null) {
                stack.add(pop.right);
            }
            if (pop.left != null) {
                stack.add(pop.left);
            }
        }
        return arrayList;
    }

    public ArrayList<Integer> postorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(0, node.val);//每次插入到头部
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return list;
    }

    @Test
    public void test() {
        TreeNode n = new TreeNode(3);
        n.left = new TreeNode(2);
        n.right = new TreeNode(1);
        ArrayList<Integer> arrayList = postorderTraversal(n);
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }
    }

    public static void preOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ");

        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void inOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.val + " ");
        inOrderRecur(head.right);
    }

    public static void posOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.val + " ");
    }

    //先序遍历的非递归的写法，反着它的顺序写
    // 1.先放中节点
    // 2.有右节点放右节点
    // 3.有左节点放左节点
    public static void preOrderUnRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print("pre-order: ");

        Stack<TreeNode> stack = new Stack<>();
        stack.add(head);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.print(pop.val + " ");
            if (pop.right != null) {
                stack.add(pop.right);
            }
            if (pop.left != null) {
                stack.add(pop.left);
            }
        }
    }
    //shift+esc 关闭

    //中序遍历的非递归的写法，
    // 1.左节点不为null则压入左节点
    // 2.左节点为null时，pop并打印，左节点
    // 3.在往右，右节点为null时，pop并打印
    // 4.右节点不为null时，压入右节点
    //还是背下来吧
    public static void inOrderUnRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print("in-order: ");

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.val + " ");
                head = head.right;
            }
        }
    }


    //和前序遍历一样的只不过是使用了两个栈
    //在前序遍历的时候将 中 右 左 节点压栈
    //在原来是打印的地方不打印，将本该打印的节点压到第二个栈中
    //这样第二个栈的出栈顺序就是 右 左 中了
    public static void posOrderUnRecur1(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print("pos-order: ");
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            //在这里不打印，这里我们放到第二个栈中去
            stack2.push(head);
            if (head.left != null) {
                stack.push(head.left);
            }
            if (head.right != null) {
                stack.push(head.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " ");
        }
    }

    //层次遍历
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
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
            if (poll.left != null) {
                queue.add(poll.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
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

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);

        System.out.println();

        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);

        System.out.println();

        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);

        System.out.println();
        posOrderRecur(head);

        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(head);
        System.out.println();
        inOrderUnRecur(head);
        System.out.println();
        posOrderUnRecur1(head);
//        posOrderUnRecur2(head);

    }


}
