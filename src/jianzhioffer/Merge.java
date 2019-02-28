package jianzhioffer;

import linkedList.ListNode;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 15:34
 * @Description: 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 */
public class Merge {
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode result = head;
        if(list1==null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                head.next = list1;
                list1 = list1.next;
                head = head.next;
            }else{
                head.next = list2;
                list2 = list2.next;
                head = head.next;
            }
        }
        if(list1!=null){
            head.next = list1;
        }
        if(list2!=null){
            head.next = list2;
        }
        return result.next;

    }
}
