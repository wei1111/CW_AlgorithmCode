package jzoffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/17 21:51
 * @Description: 用两个队列实现一个栈
 */
public class QueueToStack {
    private Queue<Integer> in;
    private Queue<Integer> out;

    public QueueToStack() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public void push(Integer value) {
        in.add(value);
    }

    public Integer peek() {
        while (in.size() > 1) {
            out.add(in.poll());
        }
        int res = in.poll();
        swap();
        in.add(res);
        return res;
    }

    public Integer pop() {
        if (in.size() == 0) {
            throw new RuntimeException("Stack is empty");
        }
        while (in.size() > 1) {
            out.add(in.poll());
        }
        int res = in.poll();
        swap();
        return res;
    }

    private void swap() {
        Queue<Integer> temp = in;
        in = out;
        out = temp;
    }

    public static void main(String[] args) {
        QueueToStack queueToStack = new QueueToStack();
        queueToStack.push(1);
        queueToStack.push(2);
        queueToStack.push(3);

        System.out.println(queueToStack.peek());

        System.out.println(queueToStack.pop());
        System.out.println(queueToStack.pop());
        System.out.println(queueToStack.pop());
    }
}
