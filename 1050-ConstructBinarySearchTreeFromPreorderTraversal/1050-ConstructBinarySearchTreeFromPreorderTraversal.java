// Last updated: 13/09/2025, 01:48:11
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
        int idx = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode helper(int[] preorder, int min, int max) {
        if (idx >= preorder.length) return null;

        int val = preorder[idx];
        if (val < min || val > max) return null;

        TreeNode root = new TreeNode(val);
        idx++;

        // Left subtree: values less than root
        root.left = helper(preorder, min, val - 1);

        // Right subtree: values greater than root
        root.right = helper(preorder, val + 1, max);

        return root;
    }
    }
