package dfs;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/2 16:25
 * @Description:
 */
public class AllPopSeq {
    @Test
    public void test() {
        //已知进栈序列，求出栈序列
        //典型的卡特兰数
        // C(n) = (2n)!/((n+1)!*n!)  n = 4 C(n) = 14
        LinkedList<LinkedList<Integer>> linkedLists = allPopSeq(new int[]{1, 2, 3, 4});
        System.out.println(linkedLists.size());
        linkedLists.forEach((l) -> {
            System.out.println(l);
        });
    }

    public LinkedList<LinkedList<Integer>> allPopSeq(int[] input) {
        LinkedList<LinkedList<Integer>> result = new LinkedList<>();
        if (input == null || input.length == 0) {
            return result;
        }

        LinkedList<Integer> in = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        LinkedList<Integer> out = new LinkedList<>();

        for (int i : input) {
            in.add(i);
        }
        allPopSeq(result, in, temp, out, input.length);
        return result;
    }

    private void allPopSeq(LinkedList<LinkedList<Integer>> result, LinkedList<Integer> in,
                           LinkedList<Integer> temp,
                           LinkedList<Integer> out, int len) {
        if (out.size() == len) {
            result.add(new LinkedList<>(out));
            return;
        }
        //出栈
        if (temp.size() > 0) {
            Integer t = temp.pop();
            out.add(t);
            allPopSeq(result, in, temp, out, len);
            out.poll();
            temp.push(t);
        }
        //入栈
        if (in.size() > 0) {
            Integer p = in.poll();
            temp.push(p);
            allPopSeq(result, in, temp, out, len);
            temp.pop();
            in.addFirst(p);
        }
    }
}
