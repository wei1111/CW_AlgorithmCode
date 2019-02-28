package jianzhioffer;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 19:12
 * @Description: 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintZTree {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        if(pRoot==null){
            return result;
        }
        LinkedList<TreeNode> stack1 = new LinkedList();
        LinkedList<TreeNode> stack2 = new LinkedList();
        LinkedList<TreeNode> temp = null;
        LinkedList list = new LinkedList();
        stack1.push(pRoot);
        int i = 1;
        while(i!=0){
            while(!stack1.isEmpty()){
                pRoot = stack1.remove();
                if(i%2==0){
                    list.addFirst(pRoot.val);
                }else{
                    list.addLast(pRoot.val);
                }

                if(pRoot.left!=null){
                    stack2.add(pRoot.left);
                }
                if(pRoot.right!=null){
                    stack2.add(pRoot.right);
                }
            }
            if(stack2.isEmpty()){
                i=0;
                result.add(new ArrayList(list));
            }else{
                temp = stack1;
                stack1 = stack2;
                stack2 = temp;
                result.add(new ArrayList(list));
                list.clear();
                i++;
            }
        }
        return result;
    }
}
