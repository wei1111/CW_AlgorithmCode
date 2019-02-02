package jianzhioffer;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author: wei1
 * @Date: Create in 2019/1/16 11:47
 * @Description:
 */
public class SlidingWindowMaxArray {
    //    w为窗口大小
    public int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        int len = arr.length;
        int[] result = new int[len - w + 1];
        LinkedList<Integer> window = new LinkedList<>();
        for (int i = 0, j = 0; j < len; ) {
            while (window.size() > 0 && arr[j] >= arr[window.peekLast()]) {
                window.pollLast();
            }
            window.addLast(j);
            j++;
            if (j - w == window.peekFirst()) {
                window.pollFirst();
            }
            if (j > w - 1) {
                result[i++] = arr[window.peekFirst()];
            }
        }
        return result;
    }

    @Test
    public void test() {
        //5,5,5,5,6,6
        int[] maxWindow = getMaxWindow(new int[]{3, 4, 5, 5, 1, 2, 6, 3}, 3);
        System.out.println(Arrays.toString(maxWindow));

        int a = 1;
        int b = 2;
        int c = 3;
        a = b = c;
        System.out.println(a + " " + b + " " + c);
    }
}
