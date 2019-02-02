package jianzhioffer;

import org.junit.Test;
import tree.TreeNode;

import java.util.LinkedList;

/**
 * @Author: wei1
 * @Date: Create in 2019/1/11 23:57
 * @Description:
 */
public class Demo {
    String Serialize(TreeNode root) {
        if(root==null){
            return "#!";
        }
        String str1 = Serialize(root.left);
        String str2 = Serialize(root.right);
        return root.val+"!"+str1+str2;
    }

    TreeNode Deserialize(String str) {
        return Deserialize(str.split("!"),0);
    }
    TreeNode Deserialize(String[] strs ,int index) {
        if(strs[index].equals("#")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(strs[index]));
        node.left = Deserialize(strs,index+1);
        node.right = Deserialize(strs,index+1);
        return node;
    }

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        String serialize = Serialize(treeNode);
        System.out.println(serialize);
    }

    @Test
    public void test1() {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
        }
        System.out.println(linkedList);
    }
}
