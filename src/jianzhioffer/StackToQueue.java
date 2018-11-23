package jianzhioffer;

import java.util.Stack;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/9 15:13
 * @Description: 用两个栈来实现一个队列，完成队列的Push和Pop操作。
 * 队列中的元素为int类型。
 */
public class StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
//        这个想法很不好
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(node);
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
    }

    public int pop() {
        if (stack2.empty()) {
            return 0;
        }
        return stack2.pop();
    }

    /**
     * 入队：将元素进栈A
     * 出队：判断栈B是否为空，如果为空，则将栈A中所有元素pop，并push进栈B，栈B出栈；
     * 如果不为空，栈B直接出栈。
     */
    public int pop2() {
        if (stack2.empty()) {
            if (stack1.empty()) {
                return 0;
            }
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public void push2(int node) {
        stack1.push(node);
    }
}
