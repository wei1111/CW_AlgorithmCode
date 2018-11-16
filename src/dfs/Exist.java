package dfs;

import org.junit.Test;

/**
 * @Author: wei1 on 2018/9/10 21:18
 */
public class Exist {
    /**
     * @param board: A list of lists of character
     * @param word:  A string
     * @return: A boolean
     * <p>
     * 123. 单词搜索
     * 给出一个二维的字母板和一个单词，寻找字母板网格中是否存在这个单词。
     * <p>
     * 单词可以由按顺序的相邻单元的字母组成，其中相邻单元指的是水平或者垂直方向相邻。
     * 每个单元中的字母最多只能使用一次。
     * <p>
     * 样例
     * 给出board =
     * <p>
     * [
     * <p>
     * "ABCE",
     * <p>
     * "SFCS",
     * <p>
     * "ADEE"
     * <p>
     * ]
     * <p>
     * word = "ABCCED"， ->返回 true,
     */

    private static boolean flag = false;
    private static int time = 0;

    public boolean exist(char[][] board, String word) {
        // write your code here
        boolean[][] color = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                color[i][j] = false;
            }
        }
        int result = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, word.toCharArray(), color, result, i, j);
            }
        }
        return flag;
    }

    public boolean dfs(char[][] board, char[] word, boolean[][] color,
                       int result, int i, int j) {
        if (result == word.length) {
            flag = true;
            time++;
            return flag;
        }
        if (board[i][j] == word[result]) {
            System.out.println("word[result]:" + word[result]+" result:"+result);
            System.out.println(word[result]);
            result++;
            color[i][j] = true;
            if (i + 1 < board.length && !color[i + 1][j]) {
                dfs(board, word, color, result, i + 1, j);
            }
            if (i - 1 >= 0 && !color[i - 1][j]) {
                dfs(board, word, color, result, i - 1, j);
            }
            if (j + 1 < board[0].length && !color[i][j + 1]) {
                dfs(board, word, color, result, i, j + 1);
            }
            if (j - 1 >= 0 && !color[i][j - 1]) {
                dfs(board, word, color, result, i, j - 1);
            }
//            result--;
            color[i][j] = false;
        }

        return false;
    }

    @Test
    public void testExist() {
//        ["ABCE","SFCS","ADEE"]

        char[][] board = new char[3][];
        board[0] = "ABCE".toCharArray();
        board[1] = "SFCS".toCharArray();
        board[2] = "ADEE".toCharArray();
//        boolean b = exist(board, "ABCCED");
        boolean b = exist(board, "SFC");
        System.out.println(b+" "+time);
    }
}
