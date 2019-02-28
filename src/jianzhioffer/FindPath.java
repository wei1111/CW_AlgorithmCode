package jianzhioffer;

import tree.TreeNode;

import java.util.ArrayList;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 15:42
 * @Description: 输入一颗二叉树的跟节点和一个整数，打印出二叉树中
 * 结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一
 * 直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数
 * 组长度大的数组靠前)
 */
public class FindPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        ArrayList<Integer> al = new ArrayList();
        int sum  = 0;
        if(root==null){
            return result;
        }
        dfs(root,result,al,sum,target);
        return result;
    }

    private void dfs(TreeNode root, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> al, int sum, int target){
        sum+=root.val;
        al.add(root.val);
        if(root.left==null&&root.right==null){
            if(sum==target){
                result.add(new ArrayList(al));
            }
            sum -= root.val;
            al.remove(al.size()-1);
            return;
        }
        if(root.left!=null){
            dfs(root.left,result,al,sum,target);
        }
        if(root.right!=null){
            dfs(root.right,result,al,sum,target);
        }
        sum -= root.val;
        al.remove(al.size()-1);
        return;
    }
}
