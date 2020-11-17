package leetcode.problems;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: haidong.feng
 * @createdAt: 2020/11/10
 * @description:
 **/
public class BinaryTree {

    Map<Integer, Integer> memo = new HashMap<>();
    int[] preorder;

    public   TreeNode buildTree(int[] preorder, int[] inorder) {
        if (null == preorder || preorder.length == 0) {
            return null;
        }
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            memo.put(inorder[i], i);
        }
        return recursive(0, 0, inorder.length - 1);
    }

    private   TreeNode recursive(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode preRoot = new TreeNode(preorder[root]);
        int preRootIdx = memo.get(preorder[root]);
        preRoot.left = recursive(root + 1, left, preRootIdx - 1);
        preRoot.right = recursive(root + preRootIdx - left + 1, preRootIdx + 1, right);
        return preRoot;
    }


    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,2,1,7};
        int[] inorder = new int[]{9,3,2,1,7};
        TreeNode root = new BinaryTree().buildTree(preorder, inorder);
        System.out.println(JSONObject.toJSONString(root));
    }


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
    }
}
