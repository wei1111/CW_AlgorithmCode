package tree;

import org.junit.Test;
import utils.TreeNodeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/1 2:11
 * @Description: Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest
 * path from the root node down to the nearest leaf node.
 * <p>
 * 思路：
 * 递归，若为空树返回0；
 * 若左子树为空，则返回右子树的最小深度+1；（加1是因为要加上根这一层，下同）
 * 若右子树为空，则返回左子树的最小深度+1；
 * 若左右子树均不为空，则取左、右子树最小深度的较小值，+1；
 * <p>
 * 非递归，思路是层序遍历，找到第一个左右结点都为null的情况，就返回
 */
public class MinimumDepth {
    public int run(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            result++;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left == null && node.right == null) {
                    return result;
                }
            }
        }
        return result;
    }

    public int minimumDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minimumDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minimumDepth(root.left) + 1;
        }
        return Math.min(minimumDepth(root.right), minimumDepth(root.left)) + 1;
    }

    @Test
    public void test() {
        TreeNode tree = TreeNodeUtil.getTree();
        System.out.println(run(tree));
        System.out.println(minimumDepth(tree));

    }
}
