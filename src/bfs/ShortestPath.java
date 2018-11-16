package bfs;

import org.junit.Test;

import java.util.LinkedList;

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}

public class ShortestPath {
    /**
     * @param grid:        a chessboard included 0 (false) and 1 (true)
     * @param source:      a point
     * @param destination: a point
     * @return: the shortest path
     * <p>
     * 611. 骑士的最短路线
     * 给定骑士在棋盘上的 初始 位置(一个2进制矩阵 0 表示空 1 表示有障碍物)，找到到达 终点 的最短路线，返回路线的长度。如果骑士不能到达则返回 -1 。
     * <p>
     * 样例
     * [[0,0,0],
     * [0,0,0],
     * [0,0,0]]
     * source = [2, 0] destination = [2, 2] return 2
     * <p>
     * [[0,1,0],
     * [0,0,0],
     * [0,0,0]]
     * source = [2, 0] destination = [2, 2] return 6
     * <p>
     * [[0,1,0],
     * [0,0,1],
     * [0,0,0]]
     * source = [2, 0] destination = [2, 2] return -1
     * 说明
     * 如果骑士的位置为 (x,y)，他下一步可以到达以下这些位置:
     * <p>
     * (x + 1, y + 2)
     * (x + 1, y - 2)
     * (x - 1, y + 2)
     * (x - 1, y - 2)
     * (x + 2, y + 1)
     * (x + 2, y - 1)
     * (x - 2, y + 1)
     * (x - 2, y - 1)
     * 注意事项
     * 起点跟终点必定为空.
     * 骑士不能穿过障碍物.
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
        grid[source.x][source.y] = true;
        int result = 0;
        LinkedList<Point> currentLevelSource = new LinkedList<>();
        LinkedList<Point> nextLevelSource = new LinkedList<>();
        if (source.x == destination.x && source.y == destination.y) {
            return 0;
        } else {
            currentLevelSource.add(source);
            return bfs(result, grid, currentLevelSource, nextLevelSource, destination);
        }
    }

    private int bfs(int result, boolean[][] grid, LinkedList<Point> currentLevelSource,
                    LinkedList<Point>
                            nextLevelSource, Point destination) {
        int grid_y = grid[0].length;
        int grid_x = grid.length;
        result++;
        if (currentLevelSource.size() == 0) {
            return -1;
        }
        while (currentLevelSource.size() != 0) {
            Point point = currentLevelSource.poll();
            int x = point.x;
            int y = point.y;
            if (x == destination.x && y == destination.y) {
//                因为遍历的是上一层的位置，所以返回上一层的result
                return result - 1;
            }
            if (x + 2 < grid_x && y + 1 < grid_y && grid[x + 2][y + 1] != true) {
                grid[x + 2][y + 1] = true;
                nextLevelSource.add(new Point(x + 2, y + 1));
            }
            if (x + 2 < grid_x && y - 1 >= 0 && grid[x + 2][y - 1] != true) {
                grid[x + 2][y - 1] = true;
                nextLevelSource.add(new Point(x + 2, y - 1));
            }
            if (x - 2 >= 0 && y + 1 < grid_y && grid[x - 2][y + 1] != true) {
                grid[x - 2][y + 1] = true;
                nextLevelSource.add(new Point(x - 2, y + 1));
            }
            if (x - 2 >= 0 && y - 1 >= 0 && grid[x - 2][y - 1] != true) {
                grid[x - 2][y - 1] = true;
                nextLevelSource.add(new Point(x - 2, y - 1));
            }
            if (x + 1 < grid_x && y + 2 < grid_y && grid[x + 1][y + 2] != true) {
                grid[x + 1][y + 2] = true;
                nextLevelSource.add(new Point(x + 1, y + 2));
            }
            if (x + 1 < grid_x && y - 2 >= 0 && grid[x + 1][y - 2] != true) {
                grid[x + 1][y - 2] = true;
                nextLevelSource.add(new Point(x + 1, y - 2));
            }
            if (x - 1 >= 0 && y + 2 < grid_y && grid[x - 1][y + 2] != true) {
                grid[x - 1][y + 2] = true;
                nextLevelSource.add(new Point(x - 1, y + 2));
            }
            if (x - 1 >= 0 && y - 2 >= 0 && grid[x - 1][y - 2] != true) {
                grid[x - 1][y - 2] = true;
                nextLevelSource.add(new Point(x - 1, y - 2));
            }
        }
        return bfs(result, grid, nextLevelSource, currentLevelSource, destination);
    }

    @Test
    public void testShortestPath() {
        int n = 6;
        int m = 8;
        boolean[][] grid = new boolean[m][n];

        Point source = new Point(2, 0);
        Point destination = new Point(2, 2);
//        [[0,0,0,0,1,1],[1,0,1,0,0,1],[0,0,1,0,0,1],[0,0,1,1,0,1],
//        [1,0,1,0,0,1],[0,0,1,0,0,1],[0,0,1,0,0,1],[0,0,1,0,0,1]]

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = false;
            }
        }

        grid[0][4] = true;
        grid[0][5] = true;

        grid[1][0] = true;
        grid[1][2] = true;
        grid[1][5] = true;

        grid[2][2] = true;
        grid[2][5] = true;

        grid[3][2] = true;
        grid[3][3] = true;
        grid[3][5] = true;

        grid[4][0] = true;
        grid[4][2] = true;
        grid[4][5] = true;

        grid[5][2] = true;
        grid[5][5] = true;

        grid[6][2] = true;
        grid[6][5] = true;

        grid[7][2] = true;
        grid[7][5] = true;

        int result = shortestPath(grid, source, destination);
        System.out.println(result);
    }
}
