package tree;

import org.junit.Test;
import utils.TreeNodeUtil;

/**
 * @Author: wei1
 * @Date: Create in 2018/12/5 15:13
 * @Description: 求二叉树最长距离
 * 任意两个节点最长路径为二叉树最长距离
 * 1>
 */
public class GetMaxPath {
    class ReturnType {
        int maxDistance;
        int depth;

        public ReturnType(int maxDistance, int depth) {
            this.maxDistance = maxDistance;
            this.depth = depth;
        }
    }

    public ReturnType process(TreeNode head) {
        if (head == null) {
            return new ReturnType(0, 0);
        }

        ReturnType leftReturn = process(head.left);
        ReturnType rightReturn = process(head.right);

        int max = Math.max(Math.max(leftReturn.maxDistance, rightReturn.maxDistance), leftReturn
                .depth + 1 + rightReturn.depth);
        return new ReturnType(max, 1 + Math.max(leftReturn.depth, rightReturn.depth));
    }

    @Test
    public void test() {
        TreeNode head = new TreeNode(6);

        TreeNodeUtil.printTree(head);

        System.out.println(process(head).maxDistance);
    }
}
