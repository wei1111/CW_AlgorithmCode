package dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueens {
    /**
     * @param n: The number of queens
     * @return: All distinct solutions
     * <p>
     * 33. N皇后问题
     * n皇后问题是将n个皇后放置在n*n的棋盘上，皇后彼此之间不能相互攻击。
     * <p>
     * 给定一个整数n，返回所有不同的n皇后问题的解决方案。
     * <p>
     * 每个解决方案包含一个明确的n皇后放置布局，其中“Q”和“.”分别表示一个女王和一个空位置。
     * <p>
     * 样例
     * 对于4皇后问题存在两种解决的方案：
     * <p>
     * [
     * <p>
     * [".Q..", // Solution 1
     * <p>
     * "...Q",
     * <p>
     * "Q...",
     * <p>
     * "..Q."],
     * <p>
     * ["..Q.", // Solution 2
     * <p>
     * "Q...",
     * <p>
     * "...Q",
     * <p>
     * ".Q.."]
     * <p>
     * ]
     * <p>
     * 挑战
     * 你能否不使用递归完成？
     */
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        List<Integer> cols = new ArrayList<>();
        dfsSearch(result, cols, n);
        return result;
    }

    public void dfsSearch(List<List<String>> result,
                          List<Integer> cols, int n) {
        if (cols.size() == n) {

            result.add(drawChessboard(cols));
            return;
        }

        for (int colIndex = 0; colIndex < n; colIndex++) {
            //如果不可放置就跳过
            if (!isValid(cols, colIndex)) {
                continue;
            }
            cols.add(colIndex);
            dfsSearch(result, cols, n);
            cols.remove(cols.size() - 1);
        }
    }

    private List<String> drawChessboard(List<Integer> cols) {
        List<String> chessboard = new ArrayList<>();
        for (int row = 0; row < cols.size(); row++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int col = 0; col < cols.size(); col++) {
                stringBuilder.append(cols.get(row) == col ? 'Q' : '.');
            }
            chessboard.add(stringBuilder.toString());
        }
        return chessboard;
    }

    private boolean isValid(List<Integer> cols, int column) {
        //这里把cols的坐标作为rowIndex，其中储存的值维colIndex
        //因为下一个存储在cols
        int row = cols.size();
        for (int rowIndex = 0; rowIndex < cols.size(); rowIndex++) {
            if (cols.get(rowIndex) == column) {
                return false;
            }
            if (cols.get(rowIndex) - column == rowIndex - row) {
                return false;
            }
            if (cols.get(rowIndex) - column == row - rowIndex) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testSolveNQueens() {
        List<List<String>> chessboard = solveNQueens(4);
        for (int i = 0; i < chessboard.size(); i++) {
            System.out.println(chessboard.get(i).toString());
        }
    }
}
