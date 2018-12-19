package sort;

import linkedList.ListNode;
import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/18 17:19
 * @Description:
 */
public class Demo {
    public ListNode listSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //可以使用归并，归并并不在意所在位置的索引
        ListNode fast = head;
        ListNode slow = head;
        ListNode n = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            n = slow;
            slow = slow.next;
        }
        n.next = null;
        ListNode sNode = listSort(head);
        ListNode fNode = listSort(slow);

        return merge(sNode, fNode);
    }

    private ListNode merge(ListNode sNode, ListNode fNode) {
        ListNode head = new ListNode();
        ListNode h = head;
        while (sNode != null && fNode != null) {
            if (sNode.val <= fNode.val) {
                head.next = sNode;
                head = head.next;
                sNode = sNode.next;
            } else {
                head.next = fNode;
                head = head.next;
                fNode = fNode.next;
            }
        }
        if (sNode != null) {
            head.next = sNode;
        }
        if (fNode != null) {
            head.next = fNode;
        }
        return h.next;
    }

    @Test
    public void test() {
        //        4->2->1->3
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(3);
        ListNode listNode = listSort(l1);
        System.out.println(listNode);
    }
}
