// Last updated: 13/09/2025, 01:51:06
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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st= new Stack<>();
        List<Integer> result=new ArrayList<>();
        TreeNode curr=root;
        while(curr!=null || !st.isEmpty()){
            if(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            else{
               TreeNode temp=st.peek().right;
                if(temp==null){
                    temp=st.pop();
                    result.add(temp.val);
                    while(!st.isEmpty() && temp==st.peek().right){
                        temp=st.pop();
                        result.add(temp.val);
                    }
                }
                else{
                    curr=temp;
                }
            }
        }
        return result;
    }
}