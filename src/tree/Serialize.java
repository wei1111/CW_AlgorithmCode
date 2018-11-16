package tree;

import org.junit.Test;

import java.util.LinkedList;

//7. 二叉树的序列化和反序列化
public class Serialize {
    public LinkedList<String> split(String string) {
        LinkedList<String> linkedList = new LinkedList<>();
        String[] strings = string.split("!");
        for (String str : strings) {
            linkedList.offer(str);
        }
        return linkedList;
    }

    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        String string = "";
        if (root == null) {
            return string + "#!";
        }
        string += root.val + "!";
        string += serialize(root.left);
        string += serialize(root.right);
        return string;
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        LinkedList<String> linkedList = split(data);
        return deserialize(linkedList);
    }

    public TreeNode deserialize(LinkedList<String> linkedList) {
        // write your code here
        TreeNode treeNode = new TreeNode(0);
        if (!linkedList.isEmpty()) {
            String str = linkedList.poll();
            if (str.equals("#")) {
                return null;
            } else {
                treeNode.val = Integer.parseInt(str);
                treeNode.left = deserialize(linkedList);
                treeNode.right = deserialize(linkedList);
                return treeNode;
            }
        } else {
            return null;
        }
    }

    @Test
    public void testSerialize() {
        deserialize("1!#!2!");
    }
}
