package jianzhioffer;

import tree.TreeNode;

import java.util.Stack;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 15:45
 * @Description: 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Convert {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return pRootOfTree;
        }
        Stack<TreeNode> stack = new Stack<>();
        boolean flag = true;
        TreeNode former = null;
        TreeNode result = null;
        while (!stack.isEmpty() || pRootOfTree != null) {
            if (pRootOfTree != null) {
                stack.push(pRootOfTree);
                pRootOfTree = pRootOfTree.left;
            } else {
                pRootOfTree = stack.pop();
                if (flag) {
                    result = pRootOfTree;
                    former = result;
                    flag = false;
                } else {
                    former.right = pRootOfTree;
                    pRootOfTree.left = former;
                    former = pRootOfTree;
                }
//                System.out.print(head.val + " ");
                pRootOfTree = pRootOfTree.right;
            }
        }
        return result;
    }
}
