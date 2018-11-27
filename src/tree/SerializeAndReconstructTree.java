package tree;

import org.junit.Test;
import utils.TreeNodeUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/23 16:33
 * @Description:
 */
public class SerializeAndReconstructTree {
    //记住按什么序列化，就按什么反序列化就可以了
    public String serialByPre(TreeNode head) {
        if (head == null) {
            return "#!";
        }
        String s = head.val + "!";
        String s1 = serialByPre(head.left);
        System.out.print(s+" ");
        String s2 = serialByPre(head.right);

        return s + s1 + s2;
    }

    //这个感觉真是一个好方法
    public TreeNode reconPreOrder(Queue<String> queue) {
        TreeNode node = null;
        if (!queue.isEmpty()) {
            String s = queue.poll();
            if (!s.equals("#")) {
                node = new TreeNode(Integer.parseInt(s));
            }
        }
        if (node == null) {
            return null;
        }
        node.left = reconPreOrder(queue);
        node.right = reconPreOrder(queue);
        return node;
    }


    @Test
    public void test() {
        TreeNode head = TreeNodeUtil.getTree();
        PrintBinaryTree.printTree(head);
        System.out.println();

        String s = serialByPre(head);
        System.out.println();
        System.out.println(s);

        String[] strings = s.split("!");
        Queue<String> queue = new LinkedList<String>(Arrays.asList(strings));

        TreeNode newHead = reconPreOrder(queue);

        System.out.println();
        serialByPre(newHead);
        System.out.println();
        PrintBinaryTree.printTree(newHead);
    }

}
