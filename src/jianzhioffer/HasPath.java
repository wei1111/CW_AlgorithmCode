package jianzhioffer;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 19:18
 * @Description: 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不
 * 包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进
 * 入该格子。
 */
public class HasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix==null||str==null||matrix.length!=(rows*cols)){
            return false;
        }
        boolean[] hasVisit = new boolean[rows*cols];
        boolean [] hasP = new boolean[1];
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                dfs(matrix,rows,cols,i,j,hasVisit,0,str,hasP);
                if(hasP[0]){
                    return true;
                }
            }
        }
        return false;
    }

    public void dfs(char[] matrix,int rows,int cols,int i,int j,boolean[] hasVisit,
                    int size,char[] str,boolean[] hasP){
        if(i<0||j<0||i>=rows||j>=cols){
            return;
        }
        if(hasVisit[i*cols+j]||str[size]!=matrix[i*cols+j]){
            return;
        }
        if(size==str.length-1){
            hasP[0] = true;
            return;
        }
        hasVisit[i*cols+j] = true;
        dfs(matrix,rows,cols,i-1,j,hasVisit,size+1,str,hasP);
        if(!hasP[0]){
            dfs(matrix,rows,cols,i+1,j,hasVisit,size+1,str,hasP);
        }
        if(!hasP[0]){
            dfs(matrix,rows,cols,i,j-1,hasVisit,size+1,str,hasP);
        }
        if(!hasP[0]){
            dfs(matrix,rows,cols,i,j+1,hasVisit,size+1,str,hasP);
        }
        hasVisit[i*cols+j] = false;
    }
}
