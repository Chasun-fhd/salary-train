package examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: haidong.feng
 * @createdAt: 2020/9/16
 * @description:
 **/
public class TreeTraverse {

    public static void main(String[] args) {
        TreeTraverse invoker = new TreeTraverse();
        TreeNode root = invoker.init();
        //System.out.println(JSONObject.toJSONString(root));
        List<Integer> retList = new ArrayList<>();
        invoker.preOrderTraverse(root, retList);
        retList.forEach(e -> System.out.print(e + "->"));
        retList.clear();
        System.out.println("\n==========================");
        invoker.midOrderTraverse(root, retList);
        retList.forEach(e -> System.out.print(e + "->"));
        System.out.println("\n==========================");
        retList.clear();
        invoker.afterOrderTraverse(root, retList);
        retList.forEach(e -> System.out.print(e + "->"));
    }

    private void preOrderTraverse(TreeNode root, List<Integer> retList) {
        if (root == null) {
            return;
        }
        retList.add(root.value);
        preOrderTraverse(root.left, retList);
        preOrderTraverse(root.right, retList);
    }

    private void midOrderTraverse(TreeNode root, List<Integer> retList) {
        if (root == null) {
            return;
        }
        midOrderTraverse(root.left, retList);
        retList.add(root.value);
        midOrderTraverse(root.right, retList);
    }

    private void afterOrderTraverse(TreeNode root, List<Integer> retList) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode empty = new TreeNode(-1);
        stack.push(root);
        while (!stack.empty()) {
            TreeNode first = stack.firstElement();
            if(first == empty) {
                stack.pop();
                retList.add(stack.firstElement().value);
                stack.pop();
                continue;
            }

            stack.push(empty);

            if(first.left != null) {
                stack.push(first.left);
            }
            if(first.right != null) {
                stack.push(first.right);
            }
        }

    }

    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }
    }

    TreeNode init() {

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(5);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);

        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(2);

        return root;
    }
}
