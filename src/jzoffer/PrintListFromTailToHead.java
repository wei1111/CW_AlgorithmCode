package jzoffer;

import linkedList.ListNode;

import java.util.ArrayList;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/8 23:45
 * @Description: 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * 这题牛客网上某个答案实在是惊艳
 */
public class PrintListFromTailToHead {

    ArrayList<Integer> arrayList = new ArrayList();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return arrayList;
        }
        printListFromTailToHead(listNode.next);
        arrayList.add(listNode.val);
        return arrayList;
    }
}
