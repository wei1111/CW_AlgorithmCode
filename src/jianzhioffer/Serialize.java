package jianzhioffer;

import tree.TreeNode;

/**
 * @Author: wei1
 * @Date: Create in 2019/2/28 19:13
 * @Description: 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class Serialize {
    String Serialize(TreeNode root) {
        if(root==null){
            return "#!";
        }
        String str1 = Serialize(root.left);
        String str2 = Serialize(root.right);
        return root.val+"!"+str1+str2;
    }

    int index =0;
    TreeNode Deserialize(String str) {
        return Deserialize(str.split("!"));
    }
    TreeNode Deserialize(String[] strs) {
        if(strs[index].equals("#")){
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(strs[index]));
        index++;
        node.left = Deserialize(strs);
        node.right = Deserialize(strs);
        return node;
    }
}
