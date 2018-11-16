package jzoffer;

import org.junit.Test;
import tree.TreeNode;

/**
 * @Author: wei1
 * @Date: Create in 2018/11/9 0:07
 * @Description: 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如
 * 输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,
 * 3,8,6}，则重建二叉树并返回。
 */
public class ReConstructBinaryTree {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return cBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }


    public TreeNode cBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn,
                                int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[startPre]);

        for (int j = startIn; j <= endIn; j++) {
            if (in[j] == pre[startPre]) {
                treeNode.left =
                        cBinaryTree(pre, startPre + 1, startPre + j - startIn, in, startIn, j -
                                1);
                treeNode.right =
                        cBinaryTree(pre, startPre + j - startIn + 1, endPre, in, j + 1, endIn);
                //这里很重要
                break;
            }
        }
        return treeNode;
    }

    @Test
    public void test() {
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        reConstructBinaryTree(pre, in);
    }
}