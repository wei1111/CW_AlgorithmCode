package linkedList;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/18 19:55
 * @Description:
 */
public class FindKthToTail {
    public ListNode findKthToTail(ListNode head,int k) {
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

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        findKthToTail(head, 5);
        System.out.println();
    }
}
