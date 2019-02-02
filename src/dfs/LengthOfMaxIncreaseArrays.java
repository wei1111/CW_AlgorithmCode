package dfs;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @Author: wei1
 * @Date: Create in 2019/1/16 12:28
 * @Description: nums =
 * [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * return [1,2,6,9]
 * //dfs+dp
 */
public class LengthOfMaxIncreaseArrays {
    public LinkedList<LinkedList<Integer>> lengthOfMaxIncreaseArrays(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int row = arr.length;
        int col = arr[0].length;
        LinkedList<LinkedList<Integer>> result = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(arr, i, j, result, temp);
            }
        }
        return result;
    }

    private void dfs(int[][] arr, int i, int j, LinkedList<LinkedList<Integer>> result,
                     LinkedList<Integer> temp) {
        if (i - 1 >= 0 && (temp.isEmpty() || arr[i - 1][j] > temp.peekLast())) {
            temp.addLast(arr[i - 1][j]);
            dfs(arr, i - 1, j, result, temp);
        }
        if (i + 1 < arr.length && (temp.isEmpty() || arr[i + 1][j] > temp.peekLast())) {
            temp.addLast(arr[i + 1][j]);
            dfs(arr, i + 1, j, result, temp);
        }
        if (j - 1 >= 0 && (temp.isEmpty() || arr[i][j - 1] > temp.peekLast())) {
            temp.addLast(arr[i][j - 1]);
            dfs(arr, i, j - 1, result, temp);
        }
        if (j + 1 < arr[0].length && (temp.isEmpty() || arr[i][j + 1] > temp.peekLast())) {
            temp.addLast(arr[i][j + 1]);
            dfs(arr, i, j + 1, result, temp);
        }
        result.addLast(new LinkedList<>(temp));
        temp.pollLast();
    }

    public int lengthOfMaxIncreaseArrays2(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int row = arr.length;
        int col = arr[0].length;
        int[][] dp = new int[row][col];
        LinkedList<Integer> temp = new LinkedList<>();
        int result = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = dfs2(arr, i, j, 1, 0, dp);
                result = Math.max(dp[i][j], result);
            }
        }
        return result;
    }

    private int dfs2(int[][] arr, int i, int j, int size, int result, int[][] dp) {
        if (dp[i][j] != 0) {
            return Math.max(result, dp[i][j] + size - 1);
        }
        if (i - 1 >= 0 && (arr[i - 1][j] > arr[i][j])) {
            result = Math.max(result, ++size);
            result = dfs2(arr, i - 1, j, size--, result, dp);
        }
        if (i + 1 < arr.length && (arr[i + 1][j] > arr[i][j])) {
            result = Math.max(result, ++size);
            result = dfs2(arr, i + 1, j, size--, result, dp);
        }
        if (j - 1 >= 0 && (arr[i][j - 1] > arr[i][j])) {
            result = Math.max(result, ++size);
            result = dfs2(arr, i, j - 1, size--, result, dp);
        }
        if (j + 1 < arr[0].length && (arr[i][j + 1] > arr[i][j])) {
            result = Math.max(result, ++size);
            result = dfs2(arr, i, j + 1, size--, result, dp);
        }
        return result;
    }

    @Test
    public void test() {
        int[][] arr = {
                {1, 2, 4},
                {6, 7, 8},
                {3, 1, 1},
                {2, 1, 0}
        };
        LinkedList<LinkedList<Integer>> linkedLists = lengthOfMaxIncreaseArrays(arr);
        for (LinkedList<Integer> linkedList : linkedLists) {
            System.out.println(linkedList);
        }
        System.out.println("------");
        System.out.println(lengthOfMaxIncreaseArrays2(arr));
    }
}
