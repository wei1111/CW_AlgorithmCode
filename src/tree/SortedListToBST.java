package tree;

import linkedList.ListNode;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @Author: wei1
 * @Date: Create in 2019/1/28 23:33
 * @Description:
 */
public class SortedListToBST {

    @Test
    public void test() {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
        TreeNode treeNode = sortedListToBST(head);
        ArrayList arrayList;
        int[] i;
        String s;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        TreeNode root = dfs(head);
        print(root);
        return root;
    }

    public void print(TreeNode root) {
        if (root == null) {
            return;
        }
        print(root.left);
        System.out.print(root.val+" ");
        print(root.right);
    }
    public TreeNode dfs(ListNode head){
        if(head==null){
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode node = getMid(head);
        TreeNode tree = new TreeNode(node.val);
        tree.left = dfs(head);
        tree.right = dfs(node.next);
        return tree;
    }

    public ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode temp = head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            temp = slow;
            slow = slow.next;
        }
        temp.next = null;
        return slow;
    }
}
