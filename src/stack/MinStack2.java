package stack;

import org.junit.Test;

import java.util.LinkedList;

public class MinStack2 {
    /**
     * 带最小值操作的栈
     * 实现一个带有取最小值min方法的栈，min方法将返回当前栈中的最小值。
     * <p>
     * 你实现的栈将支持push，pop 和 min 操作，所有操作要求都在O(1)时间内完成。
     * <p>
     * 样例
     * 如下操作：push(1)，pop()，push(2)，push(3)，min()， push(1)，min() 返回 1，2，1
     * <p>
     * 注意事项
     * 如果堆栈中没有数字则不能进行min方法的调用
     * <p>
     * 使用tree树进行排序，有点稀烂
     */

//    采用两个栈储存，第二个栈压入最小元素。
//
//    已有小元素也压入mins栈，保持mins栈与date栈数量一样，原因是可以解决很多问题。若只用一个普通变量保存最小，若栈里有多个最小值，弹出不知道数量。
//
//    例如date中有[1,1,1,2,2,3,1] pop掉1，无法判断是否还有最小值。保持mins与date数量一样，没有跟新之前一直压入当前最小值
    private LinkedList<Integer> linkedList;
    private LinkedList<Integer> minStack;

    public MinStack2() {
        // do intialization if necessary
        linkedList = new LinkedList();
        minStack = new LinkedList<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        if (linkedList.isEmpty()) {
            minStack.offer(number);
        } else if (number <= minStack.peek()) {
//            minStack.clear();
            minStack.offerFirst(number);
        } else if (number == linkedList.peek()) {
            minStack.offer(number);
        }
        linkedList.push(number);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if (linkedList != null) {
            int stackPop = linkedList.pop();
            if (stackPop == minStack.peek()) {
                minStack.pop();
            }
            return stackPop;
        } else {
            return 0;
        }
    }


    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return minStack.peek();
    }

    @Test
    public void testMinStack2() {
        MinStack2 minStack2 = new MinStack2();

        minStack2.push(-100);
        minStack2.min();
        minStack2.push(-99);
        minStack2.min();

    }
}
