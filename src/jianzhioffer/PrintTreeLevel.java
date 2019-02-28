package jianzhioffer;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 19:13
 * @Description: 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class PrintTreeLevel {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        if (pRoot == null) {
            return result;
        }
        LinkedList<TreeNode> stack1 = new LinkedList();
        LinkedList<TreeNode> stack2 = new LinkedList();
        LinkedList<TreeNode> temp = null;
        LinkedList list = new LinkedList();
        stack1.push(pRoot);
        int i = 1;
        while (i != 0) {
            while (!stack1.isEmpty()) {
                pRoot = stack1.remove();
                list.add(pRoot.val);

                if (pRoot.left != null) {
                    stack2.add(pRoot.left);
                }
                if (pRoot.right != null) {
                    stack2.add(pRoot.right);
                }
            }
            if (stack2.isEmpty()) {
                result.add(new ArrayList(list));
                i = 0;
            } else {
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
