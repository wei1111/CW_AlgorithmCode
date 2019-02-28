package jianzhioffer;

import tree.TreeNode;

import java.util.Stack;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 19:14
 * @Description: 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）
 * 中，按结点数值大小顺序第三小结点的值为4。
 */
public class KthNode {
    TreeNode KthNode(TreeNode pRoot, int k){
        if (pRoot == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || pRoot != null) {
            if (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            } else {
                pRoot = stack.pop();
                if(--k == 0){
                    return pRoot;
                }
                pRoot = pRoot.right;
            }
        }
        return null;
    }
}
