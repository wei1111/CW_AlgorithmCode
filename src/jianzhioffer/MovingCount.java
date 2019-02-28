package jianzhioffer;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 19:19
 * @Description: 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位
 * 之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class MovingCount {
    public int movingCount(int threshold, int rows, int cols)
    {
        if (rows <= 0 || cols <= 0 || threshold < 0) {
            return 0;
        }
        boolean[][] hasVisit = new boolean[rows][cols];
        int[] result = new int[1];
        dfs(0, 0, threshold, rows, cols, result, hasVisit);
        int t = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasVisit[i][j]) {
                    t++;
                }
            }
        }
        System.out.println(t);
        return result[0];
    }

    public void dfs(int x,int y,int threshold,int rows,int cols,int[] result,boolean[][] hasVisit){
        if(x==rows||y==cols||hasVisit[x][y]||numSum(x)+numSum(y)>threshold){
            return;
        }
        result[0]++;
        hasVisit[x][y] = true;
        dfs(x+1,y,threshold,rows,cols,result,hasVisit);
        dfs(x,y+1,threshold,rows,cols,result,hasVisit);
        //hasVisit[x][y] = false;
    }

    private int numSum(int i) {
        int sum = 0;
        do{
            sum += i%10;
        }while((i = i/10) > 0);
        return sum;
    }
}
