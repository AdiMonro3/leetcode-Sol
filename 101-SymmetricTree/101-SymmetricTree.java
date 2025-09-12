// Last updated: 13/09/2025, 01:51:38
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
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // Both nodes are null
        if (t1 == null && t2 == null) return true;

        // Only one node is null
        if (t1 == null || t2 == null) return false;

        // Values must match and subtrees must be mirrors
        return (t1.val == t2.val)
            && isMirror(t1.left, t2.right)
            && isMirror(t1.right, t2.left);
    }
}