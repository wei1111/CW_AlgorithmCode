package sort;

import linkedList.ListNode;
import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/2 21:04
 * @Description: Sort a linked list in O(n log n) time using constant space complexity.
 * Sort a linked list in O(n log n) time using constant space complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 * <p>
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * <p>
 * 解法：
 * 在链表上采用O(n log n)
 * 很多排序算法都要按index查找元素
 * 只有归并排序满足要求
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pend = head;

        while (fast != null && fast.next != null) {
            pend = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pend.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode newH = new ListNode(Integer.MIN_VALUE);
        ListNode cur = newH;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
                cur = cur.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
                cur = cur.next;
            }
        }
        while (head1 != null) {
            cur.next = head1;
            head1 = head1.next;
            cur = cur.next;
        }
        while (head2 != null) {
            cur.next = head2;
            head2 = head2.next;
            cur = cur.next;
        }
        return newH.next;
    }

    @Test
    public void test() {
//        4->2->1->3
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(3);
        ListNode listNode = sortList(l1);
        System.out.println(listNode);
    }


}
