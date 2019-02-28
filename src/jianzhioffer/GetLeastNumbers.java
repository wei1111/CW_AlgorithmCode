package jianzhioffer;

import java.util.ArrayList;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 15:47
 * @Description: 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbers {
    public ArrayList<Integer> getLeastNumbers(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList();
        if (input == null || k <= 0||k>input.length) {
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

    public void swap(int[] arr, int x, int y) {
        if (arr == null || arr.length == 0 || x < 0 || y >= arr.length) {
            return;
        }
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
