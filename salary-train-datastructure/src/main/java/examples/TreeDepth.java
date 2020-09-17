package examples;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: haidong.feng
 * @createdAt: 2020/8/18
 * @description:
 **/
public class TreeDepth {

    static class TreeNode {

        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }

        @Override
        public String toString() {
            return "R[" + this.val + "]";
        }
    }

    /**
     * 递归方式
     *
     * @param root
     * @return
     */
    public static int recursiveMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = recursiveMaxDepth(root.left);
        int rightMax = recursiveMaxDepth(root.right);
        return Math.max(leftMax, rightMax) + 1;
    }

    /**
     * 广度优先
     *
     * @param root
     */
    public static int breadthFirstMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode l12 = new TreeNode(3);
        TreeNode l13 = new TreeNode(4);
        TreeNode l2 = new TreeNode(5);
        TreeNode l21 = new TreeNode(6);
        TreeNode l22 = new TreeNode(7);

        root.left = l1;
        root.left.left = l12;
        root.left.right = l13;

        root.right = l2;
        root.right.left = l21;
        root.right.right = l22;

        System.out.println(root);
        System.out.println(recursiveMaxDepth(root));
        System.out.println(breadthFirstMaxDepth(root));
    }
}
