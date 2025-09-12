// Last updated: 13/09/2025, 01:48:19
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
    // 0 means covered without camera
    // 1 means covered with camera
    // -1 means not covered
    int count=0;
    public int dfs(TreeNode root){
        if(root==null) return 0;
        int left=dfs(root.left);
        int right=dfs(root.right);

        if(left==-1 || right==-1){
            count++;
            return 1;
        } 
        if(left==1 || right==1) {
            return 0;
        }
        return -1;

    }
    public int minCameraCover(TreeNode root) {
        if(dfs(root)==-1) count++;
        return count;
        
    }
}