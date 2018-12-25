package dfs;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/19 17:43
 * @Description:
 */
public class Demo {
    public ArrayList<Integer> getLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList();
        if (input == null || k <= 0) {
            return result;
        }

        getL(input, 0, input.length - 1, k);
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    private void getL(int[] input, int start, int end, int k) {
        if (start >= end) {
            return;
        }
        int r = start + (int) (Math.random() * (end - start + 1));
        if (r < start || r > end) {
            System.out.println(r);
        }
        int random = input[r];

        int[] p = partition(input, 0, input.length - 1, random, k - 1);
        if (p[0] > k) {
            getL(input, start, p[0] - 1, k);
        } else if (p[1] < k) {
            getL(input, p[1] + 1, end, k);
        }
    }

    private int[] partition(int[] input, int start, int end, int random, int k) {
        int s = start;
        int less = start - 1;
        int more = end + 1;
        while (start < more) {
            if (input[start] < random) {
                swap(input, ++less, start++);
            } else if (input[start] > random) {
                swap(input, --more, start);
            } else {
                start++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    @Test
    public void test() {
        for (int j = 0; j < 1000; j++) {
            int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
            getLeastNumbers_Solution(arr, 4);
            for (int i = 0; i < 4; i++) {
                if (arr[i] > 4) {
                    System.out.print("err-------" + arr[i] + "-------err ");
                }
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public void swap(int[] arr, int x, int y) {
        if (arr == null || arr.length == 0 || x < 0 || y >= arr.length) {
            return;
        }
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}


