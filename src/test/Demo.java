package test;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @Author: wei1
 * @Date: Create in 2019/1/31 23:34
 * @Description:
 */
public class Demo {
    @Test
    public void test() {
        LinkedList<LinkedList<Integer>> linkedLists = outStack(new int[]{1, 2, 3, 4});
        System.out.println(linkedLists.size());
        linkedLists.forEach((l) -> {
            System.out.println(l);
        });
    }

    public LinkedList<LinkedList<Integer>> outStack(int[] input) {
        LinkedList<LinkedList<Integer>> result = new LinkedList<>();
        if (input == null || input.length == 0) {
            return result;
        }

        LinkedList<Integer> in = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        LinkedList<Integer> out = new LinkedList<>();

        for (int i : input) {
            //4,3,2,1
            in.addLast(i);
        }
        outStack(result, in, temp, out, input.length);
        return result;
    }

    private void outStack(LinkedList<LinkedList<Integer>> result, LinkedList<Integer> in,
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
            outStack(result, in, temp, out, len);
            out.poll();
            temp.push(t);
        }
        //入栈
        if (in.size() > 0) {
            Integer p = in.poll();
            temp.push(p);
            outStack(result, in, temp, out, len);
            temp.pop();
            in.addFirst(p);
        }
    }

    public String calculateOperationSequence(int[] originalArray, int[] resultArray) {
        int[] numStackState =
                new int[originalArray.length];//0 have not pushed, 1 have pushed, 2 have poped
        for (int i = 0; i < numStackState.length; ++i) {
            numStackState[i] = 0;
        }
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < resultArray.length; ++i) {
            int indexInOriginal = -1;
            for (int j = 0; j < originalArray.length; ++j) {
                if (originalArray[j] != resultArray[i]) {
                    if (numStackState[j] == 0) {
                        result.append("push");
                        result.append(originalArray[j]);
                        result.append("|");
                        numStackState[j] = 1;
                    }
                } else if (originalArray[j] == resultArray[i]) {
                    if (numStackState[j] == 0) {
                        result.append("push");
                        result.append(originalArray[j]);
                        result.append("|");
                        numStackState[j] = 1;
                    } else if (numStackState[j] == 2) {
                        return "None";
                    }
                    indexInOriginal = j;
                    break;
                }
            }
            if (indexInOriginal == -1) {
                return "None";
            }
            for (int j = indexInOriginal + 1; j < originalArray.length; ++j) {
                if (numStackState[j] == 1) {
                    return "None";
                }
            }
            result.append("pop");
            result.append(resultArray[i]);
            result.append("|");
            numStackState[indexInOriginal] = 2;
        }
        return result.substring(0, result.length() - 1);
    }
}
