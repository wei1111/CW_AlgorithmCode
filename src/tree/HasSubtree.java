package tree;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/18 20:19
 * @Description:
 */
public class HasSubtree {
    public boolean hasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null||root2==null){
            return false;
        }
        StringBuilder r1 = new StringBuilder();
        serialize(root1,r1);
        String s1 = r1.toString();
        System.out.println(s1);

        StringBuilder r2 = new StringBuilder();
        serialize(root2,r2);
        String s2 = r2.toString();
        System.out.println(s2);
        if(s1.contains(s2)){
            return true;
        }
        return false;
    }

    public void serialize(TreeNode root,StringBuilder res){
        if(root==null){
            res.append("#!");
            return;
        }
        res.append(root.val+"!");
        serialize(root.left,res);
        serialize(root.right,res);
    }

    @Test
    public void test() {
        TreeNode head = new TreeNode(8);
        head.left = new TreeNode(8);
        head.left.left = new TreeNode(9);
        head.left.right = new TreeNode(2);
        head.left.right.left = new TreeNode(4);
        head.left.right.right = new TreeNode(7);
        head.right = new TreeNode(7);
        boolean b = hasSubtree(head, head.left);
        System.out.println(b);
    }
}
