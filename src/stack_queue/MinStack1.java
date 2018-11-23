package stack_queue;

import java.util.LinkedList;
import java.util.TreeSet;

public class MinStack1 {
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
     *
     * 使用tree树进行排序，有点稀烂
     */

    protected LinkedList<Integer> linkedList;

    public MinStack1() {
        // do intialization if necessary
        linkedList = new LinkedList();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        linkedList.push(number);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        return linkedList.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        TreeSet<Integer> treeSet = new TreeSet(linkedList);
        return treeSet.first();
    }
}
