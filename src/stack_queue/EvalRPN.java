package stack_queue;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/2 16:55
 * @Description: 1.这种逆波兰表达式，很明显，用栈求解。
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 * <p>
 * Some examples:
 * <p>
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for (int t = 0; t < tokens.length; t++) {
            try {
                int i = Integer.parseInt(tokens[t]);
                stack.push(i);
            } catch (Exception e) {
                int b = stack.pop();
                int a = stack.pop();
                if (tokens[t].equals("+")) {
                    stack.add(a + b);
                } else if (tokens[t].equals("-")) {
                    stack.add(a - b);
                } else if (tokens[t].equals("*")) {
                    stack.add(a * b);
                } else {
                    stack.add(a / b);
                }
            }
        }
        return stack.peek();
    }

    @Test
    public void test() {
        String[] strs = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(strs));
    }
}
