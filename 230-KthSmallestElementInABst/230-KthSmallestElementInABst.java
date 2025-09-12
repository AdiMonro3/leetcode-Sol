// Last updated: 13/09/2025, 01:50:26
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
    private int count = 0;
    private int result = -1;
    private void inorder(TreeNode node, int k) {
        if (node == null) return;

        // Left
        inorder(node.left, k);

        // Node (Visit)
        count++;
        if (count == k) {
            result = node.val;
            return; // Stop traversal early
        }

        // Right
        inorder(node.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }
}