package jianzhioffer;

import linkedList.ListNode;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 15:33
 * @Description: 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode former = head;
        ListNode latter = head;
        while(k!=1&&former!=null){
            k--;
            former = former.next;
        }
        if(former==null){
            return null;
        }
        former = former.next;
        while(former!=null){
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
}
