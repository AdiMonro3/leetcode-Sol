// Last updated: 13/09/2025, 01:51:23
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
    public void flatten(TreeNode root) {
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left==null){
                curr=curr.right;
            }else{
                TreeNode prev=curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right=curr;
                    curr=curr.left;
                }else{
                    prev.right=curr.right;
                    curr.right=curr.left;
                    curr.left=null;
                    curr=curr.right;

                }
            }
        }
    }
}