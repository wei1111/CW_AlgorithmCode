package linkedList;

import org.junit.Test;

public class Reverse {
    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     * <p>
     * <p>
     * 35. 翻转链表
     * 翻转一个链表
     * <p>
     * 样例
     * 给出一个链表1->2->3->null，这个翻转后的链表为3->2->1->null
     * <p>
     * 挑战
     * 在原地一次翻转完成
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode listNodePrev = null;
        ListNode listNodeNext = null;

        while (head != null) {
            listNodeNext = head;
            head = head.next;
            listNodeNext.next = listNodePrev;
            listNodePrev = listNodeNext;
        }
        return listNodeNext;
    }

    @Test
    public void testReverse() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        showList(head);

        if (head == null) {
            System.out.println("head == null");
        }
        showList(reverse(head));

    }

    public void showList(ListNode head) {
        while (head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

    public ListNode reverse2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode former = null;
        ListNode latter = null;
        while (head != null) {
            latter = head;
            head = head.next;
            latter.next = former;
            former = latter;
        }
        return former;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode listNode = reverse2(head);
        showList(listNode);

    }
}
