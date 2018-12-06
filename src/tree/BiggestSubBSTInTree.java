package tree;

import org.junit.Test;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/5 13:21
 * @Description: 求二叉树的最大搜索二叉子树
 * 典型的树型的dp问题，分析需要返回的变量，通
 * 过返回的变量推出本次递归需要返回的变量
 * 1.左树是最大的搜索二叉树
 * 2.右树是最大的搜索二叉树
 * 3.本身就是最大的搜索二叉树
 * 根据什么可以分析出上面的三种情况呢？
 * 1>左树的size 左树的头节点 左树的最大值
 * 2>右树的size 右树的头节点 右树的最大值
 * 将1，2需要的合起来
 */
public class BiggestSubBSTInTree {
    class ReturnType {
        TreeNode head;
        int size;
        int max;
        int min;

        public ReturnType(TreeNode head, int size, int max, int min) {
            this.head = head;
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }

    public ReturnType process(TreeNode head) {
        if (head == null) {
            return new ReturnType(null, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        ReturnType leftReturn = process(head.left);
        ReturnType rightReturn = process(head.right);

        int headSize = 0;
        if (head.left == leftReturn.head && head.right == rightReturn.head &&
                head.val > leftReturn.max && head.val < rightReturn.min) {
            headSize = leftReturn.size + 1 + rightReturn.size;
        }

        int p1 = leftReturn.size;
        int p2 = rightReturn.size;
        int maxSize = Math.max(Math.max(p1, p2), headSize);

        TreeNode maxHead = leftReturn.size > rightReturn.size ? leftReturn.head : rightReturn.head;
        if (maxSize == headSize) {
            maxHead = head;
        }
        return new ReturnType(maxHead, maxSize, Math.max(Math.max(leftReturn.max, rightReturn
                .max), head.val), Math.min(Math.min(leftReturn.min, rightReturn
                .min), head.val));
    }


    public static TreeNode bigTreeNode(TreeNode head) {
        int[] record = new int[3]; // 0->size, 1->min, 2->max
        return posOrder(head, record);
    }

    public static TreeNode posOrder(TreeNode head, int[] record) {
        if (head == null) {
            record[0] = 0;
            record[1] = Integer.MAX_VALUE;
            record[2] = Integer.MIN_VALUE;
            return null;
        }
        int value = head.val;
        TreeNode left = head.left;
        TreeNode right = head.right;
        TreeNode lBST = posOrder(left, record);
        int lSize = record[0];
        int lMin = record[1];
        int lMax = record[2];
        TreeNode rBST = posOrder(right, record);
        int rSize = record[0];
        int rMin = record[1];
        int rMax = record[2];
        record[1] = Math.min(rMin, Math.min(lMin, value)); // lmin, value, rmin -> min
        record[2] = Math.max(lMax, Math.max(rMax, value)); // lmax, value, rmax -> max
        if (left == lBST && right == rBST && lMax < value && value < rMin) {
            record[0] = lSize + rSize + 1;
            return head;
        }
        record[0] = Math.max(lSize, rSize);
        return lSize > rSize ? lBST : rBST;
    }

    public static void printTree(TreeNode head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.val + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {

        TreeNode head = new TreeNode(6);
        head.left = new TreeNode(1);
        head.left.left = new TreeNode(0);
        head.left.right = new TreeNode(3);
        head.right = new TreeNode(12);
        head.right.left = new TreeNode(10);
        head.right.left.left = new TreeNode(4);
        head.right.left.left.left = new TreeNode(2);
        head.right.left.left.right = new TreeNode(5);
        head.right.left.right = new TreeNode(14);
        head.right.left.right.left = new TreeNode(11);
        head.right.left.right.right = new TreeNode(15);
        head.right.right = new TreeNode(13);
        head.right.right.left = new TreeNode(20);
        head.right.right.right = new TreeNode(16);

        printTree(head);
        ReturnType result1 = new BiggestSubBSTInTree().process(head);
        TreeNode result2 = bigTreeNode(head);

        printTree(result1.head);
        printTree(result2);

    }

    @Test
    public void test() {
        System.out.println(1 ^ 2 ^ 3);
        System.out.println(1 ^ 3 ^ 2);
        System.out.println(2 ^ 3 ^ 1);
    }
}
