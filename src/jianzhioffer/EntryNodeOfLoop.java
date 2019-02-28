package jianzhioffer;

import linkedList.ListNode;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 18:55
 * @Description: 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null){
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast){
                while(pHead!=fast){
                    pHead=pHead.next;
                    fast = fast.next;
                }
                return pHead;
            }
        }
        return null;
    }
}
