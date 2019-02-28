package jianzhioffer;

import tree.TreeNode;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 18:22
 * @Description: 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过
 * 的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class TreeDepth {
    //要知道二叉树的问题都是很简单的
    public int TreeDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(TreeDepth(root.left),TreeDepth(root.right))+1;
    }
}
