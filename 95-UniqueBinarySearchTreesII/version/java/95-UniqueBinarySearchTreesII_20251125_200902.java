// Last updated: 25/11/2025, 20:09:02
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
    // memo[start][end] stores list of all BSTs formed using values start..end
    List<TreeNode> [][] memo;
    public List<TreeNode>  helper(int l,int r){
          // If already computed, return memoized result
        if (memo[l][r] != null) {
            return memo[l][r];
        }
        List<TreeNode> result=new ArrayList<>();
        if(l>r){
            result.add(null);
            memo[l][r] = result;
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
        memo[l][r] = result;
        return result;
        
    }
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        memo = new List[n+2][n+2];  
        return helper(1, n);
    }
}