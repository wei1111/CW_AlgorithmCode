package linkedList;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/4 12:17
 * @Description: 快指针和慢指针第一个相遇时为有环，在重头来个节点与快节点相遇就是这个环的开始节点
 * Given a linked list, return the node where the cycle begins. If there is no cycle, returnnull.
 *
 * Follow up:
 * Can you solve it without using extra space?
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode begin = head;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        if (fast != slow) {
            return null;
        } else {
            while (begin != slow) {
                begin = begin.next;
                slow = slow.next;
            }
        }
        return begin;
    }
}
