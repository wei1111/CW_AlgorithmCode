package stack_queue;

import java.util.Stack;

/**
 * @Author: wei1
 * @Date: Create in 2019/1/3 21:43
 * @Description: 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数
 * 字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1
 * 是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈
 * 序列的弹出序列。（注意：这两个序列的长度是相等的）
 * <p>
 * 【思路】借用一个辅助的栈，遍历压栈顺序，先讲第一个放入栈中，
 * 这里是1，然后判断栈顶元素是不是出栈顺序的第一个元素，这里是4，
 * 很显然1≠4，所以我们继续压栈，直到相等以后开始出栈，出栈一个
 * 元素，则将出栈顺序向后移动一位，直到不相等，这样循环等压栈顺
 * 序遍历完成，如果辅助栈还不为空，说明弹出序列不是该栈的弹出顺序。
 */
public class IsPopOrder {
    public boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack();
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[popIndex]) {
                popIndex++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
