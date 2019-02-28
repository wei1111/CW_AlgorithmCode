package jianzhioffer;

import tree.TreeNode;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 19:11
 * @Description: 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class IsSymmetrical {
    //巧妙的递归啊
    boolean isSymmetrical(TreeNode pRoot)
    {
        return isSym(pRoot,pRoot);
    }

    boolean isSym(TreeNode lRoot,TreeNode rRoot){
        if(lRoot==null&&rRoot==null){
            return true;
        }
        if(lRoot==null||rRoot==null){
            return false;
        }
        if(lRoot.val!=rRoot.val){
            return false;
        }
        return isSym(lRoot.left,rRoot.right)&&isSym(lRoot.right,rRoot.left);
    }
}
