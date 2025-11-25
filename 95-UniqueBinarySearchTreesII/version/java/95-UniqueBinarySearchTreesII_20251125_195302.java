// Last updated: 25/11/2025, 19:53:02
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
    
    public List<TreeNode>  helper(int l,int r){
        List<TreeNode> result=new ArrayList<>();
        if(l>r){
            result.add(null);
            return result;
        }
        for(int i=l;i<=r;i++){
        List<TreeNode> leftTree=helper(l,i-1);
        List<TreeNode> rightTree=helper(i+1,r);
         for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    result.add(node);
                }
            }
        }
        return result;
        
    }
    public List<TreeNode> generateTrees(int n) {
         if (n == 0) return new ArrayList<>();
        return helper(1, n);
    }
}