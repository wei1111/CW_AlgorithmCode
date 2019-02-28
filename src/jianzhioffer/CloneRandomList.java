package jianzhioffer;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 15:43
 * @Description: 输入一个复杂链表（每个节点中有节点值，以及两个指针，
 * 一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复
 * 制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，
 * 否则判题程序会直接返回空）
 */

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class CloneRandomList {
    //克隆链表
    //1.现在后面克隆一个
    //2.复制每个节点的random的指针
    //2.在拆开
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode former = pHead;
        //先复制一份不带随机指针的链表到后面
        while (former != null) {
            RandomListNode temp = new RandomListNode(former.label);
            temp.next = former.next;
            former.next = temp;
            former = temp.next;
        }
        RandomListNode pHead1 = pHead;
        RandomListNode pHead2 = pHead.next;
        while (pHead1 != null) {
            if (pHead1.random != null) {
                pHead2.random = pHead1.random.next;
            } else {
                pHead2.random = null;
            }
            pHead1 = pHead2.next;
            if (pHead1 != null) {
                pHead2 = pHead1.next;
            }
        }
        //在拆开
        pHead1 = pHead;
        pHead2 = pHead.next;
        RandomListNode result = pHead2;
        while (pHead1 != null) {
            pHead1.next = pHead2.next;
            pHead1 = pHead1.next;
            if (pHead1 != null) {
                pHead2.next = pHead1.next;
                pHead2 = pHead2.next;
            }
        }
        return result;
    }
}
