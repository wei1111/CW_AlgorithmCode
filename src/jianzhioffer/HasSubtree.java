package jianzhioffer;

import tree.TreeNode;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 15:36
 * @Description: 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree {
    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if(root1==null||root2==null){
            return false;
        }
        StringBuilder r1 = new StringBuilder();
        serialize(root1,r1);
        String s1 = r1.toString();
        System.out.println(s1);

        StringBuilder r2 = new StringBuilder();
        serialize(root2,r2);
        String s2 = r2.toString();
        System.out.println(s2);
        if(s1.contains(s2)){
            return true;
        }
        return false;
    }

    public void serialize(TreeNode root,StringBuilder res){
        if(root==null){
            res.append("#!");
            return;
        }
        res.append(root.val+"!");
        serialize(root.left,res);
        serialize(root.right,res);
    }
}
