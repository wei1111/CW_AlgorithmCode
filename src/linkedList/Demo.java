package linkedList;

import org.junit.Test;
import tree.TreeNode;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/18 16:56
 * @Description:
 */
public class Demo {
    @Test
    public void test() {
//        {1,2,3,4,5,#,#,#,#,6}
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(1);
        root.left.left.left = new TreeNode(1);
        root.left.left.left.right = new TreeNode(1);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(1);
        boolean b = isBalance(root);
//        boolean b = IsBalanced_Solution2(root);
        System.out.println(b);
    }



    public static boolean isBalance(TreeNode head) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(head, 1, res);
        return res[0];
    }

    public static int getHeight(TreeNode head, int level, boolean[] res) {
        if (head == null) {
            return level;
        }
        int lH = getHeight(head.left, level + 1, res);
        if (!res[0]) {
            return level;
        }
        int rH = getHeight(head.right, level + 1, res);
        if (!res[0]) {
            return level;
        }
        if (Math.abs(lH - rH) > 1) {
            res[0] = false;
        }
        return Math.max(lH, rH);
    }



    class ReturnType {
        int max;
        int min;
        boolean isB;

        public ReturnType(int max, int min, boolean isBalanced) {
            this.max = max;
            this.min = min;
            this.isB = isBalanced;
        }
    }

    //简单的树型dp
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getHight(root).isB;
    }

    public ReturnType getHight(TreeNode root) {
        if (root == null) {
            return new ReturnType(Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        }
        ReturnType l = getHight(root.left);
        if (!l.isB) {
            return new ReturnType(0, 0, false);
        }
        ReturnType r = getHight(root.right);
        if (!r.isB) {
            return new ReturnType(0, 0, false);
        }
        int max = Math.max(Math.max(l.max, r.max), 0);
        int min = Math.min(Math.min(l.min, r.min), 0);
        boolean isB = (max - min <= 1);
        return new ReturnType(max + 1, min + 1, isB);
    }


    public boolean IsBalanced_Solution2(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getDepth(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}
