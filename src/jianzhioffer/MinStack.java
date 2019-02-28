package jianzhioffer;

import java.util.LinkedList;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 15:39
 * @Description: 定义栈的数据结构，请在该类型中实现一个能够得到
 * 栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class MinStack {
    private LinkedList<Integer> linkedList = new LinkedList<>();
    private LinkedList<Integer> minStack = new LinkedList<>();

    public void push(int node) {
        linkedList.push(node);
        if(minStack.isEmpty()){
            minStack.push(node);
            return;
        }
        int min = minStack.peek();
        if(min>node){
            minStack.push(node);
            return;
        }else{
            minStack.push(min);
        }
    }

    public void pop() {
        if(linkedList.isEmpty()){
            return;
        }else{
            int pop = linkedList.pop();
            minStack.pop();
        }
    }

    public int top() {
        if(linkedList.isEmpty()){
            return -1;
        }
        return linkedList.peek();
    }

    public int min() {
        if(minStack.isEmpty()){
            return Integer.MAX_VALUE;
        }
        return minStack.peek();
    }
}
