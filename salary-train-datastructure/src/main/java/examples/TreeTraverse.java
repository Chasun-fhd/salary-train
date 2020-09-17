package examples;

/**
 * @author: haidong.feng
 * @createdAt: 2020/9/16
 * @description:
 **/
public class TreeTraverse {

    public static void main(String[] args) {
        TreeTraverse invoker = new TreeTraverse();
        TreeNode root  = invoker.init();
        //System.out.println(JSONObject.toJSONString(root));
//        invoker.preOrderTraverse(root);
        invoker.midOrderTraverse(root);
    }

    private void preOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null || root.right != null) {
            System.out.println("root:" + root.value);
        } else {
            System.out.println("node:" + root.value);
        }
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }

    private void midOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
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
