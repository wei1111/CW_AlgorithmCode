package jianzhioffer;

import linkedList.ListNode;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 19:10
 * @Description: 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {
    //写的和屎一样。。
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        ListNode p = new ListNode(0);
        ListNode head = p;
        while (pHead != null && pHead.next != null) {
            if (pHead.val == pHead.next.val) {
                int v = pHead.val;
                while (pHead != null && pHead.val == v) {
                    pHead = pHead.next;
                }
                p.next = pHead;
            } else {
                p.next = pHead;
                p = p.next;
                pHead = pHead.next;
            }
        }
        return head.next;
    }
}
