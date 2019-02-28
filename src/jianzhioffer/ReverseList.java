package jianzhioffer;

import linkedList.ListNode;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 15:34
 * @Description: 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
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
}
