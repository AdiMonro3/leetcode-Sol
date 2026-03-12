// Last updated: 12/03/2026, 11:53:13
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
    public int amountOfTime(TreeNode root, int start) {
        int[] max = new int[1];
        dfs(root,start,max);
        return max[0];
    }
    int dfs(TreeNode root, int start, int[] max){
        if(root==null) return 0;
        int lhs = dfs(root.left, start,max);
        int rhs = dfs(root.right, start,max);
        if(lhs>=0 && rhs>=0 && root.val!=start){
            return Math.max(lhs,rhs)+1;
        }
        else if(lhs<0){
           max[0] = Math.max(max[0],rhs + Math.abs(lhs));
           return -1*(Math.abs(lhs)+1);
        }
        else if(rhs<0) {
            max[0] = Math.max(max[0],lhs + Math.abs(rhs));
           return -1*(Math.abs(rhs)+1);
        }
        
       // if(root.val == start){
            max[0] = Math.max(lhs,rhs);
            return -1;
       // } 
    }
}