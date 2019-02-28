package jianzhioffer;

import linkedList.ListNode;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 18:21
 * @Description: 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null){
            return null;
        }

        int length1 = 0;
        int length2 = 0;
        ListNode temp1 = pHead1;
        ListNode temp2 = pHead2;
        while(temp1!=null){
            length1++;
            temp1 = temp1.next;
        }
        while(temp2!=null){
            length2++;
            temp2 = temp2.next;
        }
        ListNode l = length1>length2?pHead1:pHead2;
        ListNode s  = length1>length2?pHead2:pHead1;
        int t = length1>length2?length1-length2:length2-length1;
        while(t>0){
            l = l.next;
            t--;
        }
        while(s != l){
            s = s.next;
            l = l.next;
        }
        return s;
    }
}
