package sort;

import linkedList.ListNode;
import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/3 13:52
 * @Description:
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        while (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        ListNode newHead1 = newHead;
        ListNode newHead2 = newHead.next;
        ListNode curi;
        for (ListNode i = head; i != null; ) {
            curi = i;
            i = i.next;
            ListNode curj = newHead;
            for (ListNode j = newHead;; ) {
                curj = j;
                j = j.next;
                if (j == null || curi.val <= j.val) {
                    break;
                }
            }
            curi.next = curj.next;
            curj.next = curi;
        }

        return newHead.next;
    }

    @Test
    public void test() {
        //        4->2->1->3
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(3);
        ListNode listNode = insertionSortList(l1);
        System.out.println(listNode);
    }
}
