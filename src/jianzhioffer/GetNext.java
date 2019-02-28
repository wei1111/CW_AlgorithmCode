package jianzhioffer;

import tree.TreeLinkNode;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 19:10
 * @Description: 给定一个二叉树和其中的一个结点，
 * 请找出中序遍历顺序的下一个结点并且返回。注意，
 * 树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 二叉树中序遍历的下一个节点
 */
public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode.right==null){
            if(pNode.next==null){
                return null;
            }
            if(pNode==pNode.next.left){
                return pNode.next;
            }
            //下面才是精彩
            while(pNode.next != null && pNode .next .left != pNode){
                pNode = pNode.next;
            }
            return pNode.next;
        }
        TreeLinkNode l = getLeft(pNode.right);
        return l == null?pNode.right:l;
    }

    public TreeLinkNode getLeft(TreeLinkNode pNode){
        if(pNode==null)
        {
            return null;
        }
        if(pNode.left==null){
            return null;
        }
        while(pNode.left!=null){
            pNode = pNode.left;
        }return pNode;
    }
}
