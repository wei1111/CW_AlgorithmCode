package linkedList;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/16 1:21
 * @Description: 剑指offer复制链表
 * A linked list is given such that each node contains an additional
 * random pointer which could point to any node in the list or null.
 * <p>
 * Return a deep copy of the list.
 * <p>
 * 先拷贝原链表，在拷贝随机指针，在分离链表
 */
public class CopyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {
        //拷贝原链表
        RandomListNode copy, i;
        if (head == null) {
            return null;
        }
        for (i = head; i != null; ) {
            copy = new RandomListNode(i.label);
            copy.next = i.next;
            i.next = copy;
            i = copy.next;
        }
        //拷贝随机指针
        for (i = head; i != null; ) {
            copy = i.next;
            copy.random = (i.random == null ? null : i.random.next);
            i = copy.next;
        }
        //分离链表
        for (i = head, head = i.next; i != null; ) {
            copy = i.next;
            i = i.next = copy.next;
            copy.next = (i == null ? null : i.next);
        }
        return head;
    }

    @Test
    public void test() {
        RandomListNode randomListNode = new RandomListNode(-1);
        RandomListNode randomListNode1 = copyRandomList(randomListNode);
        System.out.println(randomListNode1.label);

    }
}
