package linkedList;

import org.junit.Test;
import tree.TreeNode;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/18 16:56
 * @Description:
 */
public class Demo {

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

    @Test
    public void test() {
//"ABCE
// SFCS
// ADEE",3,4,"ABCCED"
        boolean b = hasPath("ABCESFCSADEE".toCharArray(), 3, 4, "ABCCED".toCharArray());
        System.out.println(b);
    }



    public static boolean isBalance(TreeNode head) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(head, 1, res);
        return res[0];
    }

    public static int getHeight(TreeNode head, int level, boolean[] res) {
        if (head == null) {
            return level;
        }
        int lH = getHeight(head.left, level + 1, res);
        if (!res[0]) {
            return level;
        }
        int rH = getHeight(head.right, level + 1, res);
        if (!res[0]) {
            return level;
        }
        if (Math.abs(lH - rH) > 1) {
            res[0] = false;
        }
        return Math.max(lH, rH);
    }



    class ReturnType {
        int max;
        int min;
        boolean isB;

        public ReturnType(int max, int min, boolean isBalanced) {
            this.max = max;
            this.min = min;
            this.isB = isBalanced;
        }
    }

    //简单的树型dp
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getHight(root).isB;
    }

    public ReturnType getHight(TreeNode root) {
        if (root == null) {
            return new ReturnType(Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        }
        ReturnType l = getHight(root.left);
        if (!l.isB) {
            return new ReturnType(0, 0, false);
        }
        ReturnType r = getHight(root.right);
        if (!r.isB) {
            return new ReturnType(0, 0, false);
        }
        int max = Math.max(Math.max(l.max, r.max), 0);
        int min = Math.min(Math.min(l.min, r.min), 0);
        boolean isB = (max - min <= 1);
        return new ReturnType(max + 1, min + 1, isB);
    }


    public boolean IsBalanced_Solution2(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getDepth(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}
