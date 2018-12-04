package linkedList;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/4 11:05
 * @Description: Given a singly linked list L: L 0→L 1→…→L n-1→L n,
 * reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
 * <p>
 * You must do this in-place without altering the nodes' values.
 * <p>
 * For example,
 * Given{1,2,3,4}, reorder it to{1,4,2,3}.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        //这里这样拆分使得前面的-后面的<=1对应后面的重新连接
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode after = slow.next;
        slow.next = null;

        ListNode preNode = null;
        ListNode nextNode = null;

        while (after != null) {
            nextNode = after;
            after = after.next;
            nextNode.next = preNode;
            preNode = nextNode;
        }


        ListNode h = head;
        ListNode htemp;
        ListNode ntemp;
        while (h != null && nextNode != null) {
            htemp = h.next;
            h.next = nextNode;
            h = htemp;

            ntemp = nextNode.next;
            nextNode.next = h;
            nextNode = ntemp;
        }
    }
}
