// Last updated: 13/09/2025, 01:50:51
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
    public List<Integer> helper(TreeNode root ,int level,List<Integer> ds){
        if(root==null){
            return ds;
        }
        if(level==ds.size()){
            ds.add(root.val);
        }
        helper(root.right,level+1,ds);
        helper(root.left,level+1,ds);

        return ds;
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ds=new ArrayList<>();
        
        return helper(root,0,ds);
    }
}