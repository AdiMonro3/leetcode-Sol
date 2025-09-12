// Last updated: 13/09/2025, 01:51:08
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
    public ArrayList<Integer> MorrisPreorder(TreeNode root){
       ArrayList<Integer> ans=new ArrayList<>();
       TreeNode curr=root;
       while(curr!=null){
        if(curr.left==null){
            ans.add(curr.val);
            curr=curr.right;
        }
        else{
            TreeNode prev=curr.left;
            while(prev.right!=null && prev.right!=curr){
                prev=prev.right;
            }
            if(prev.right==null){
                 ans.add(curr.val);
                 prev.right=curr;
                 curr=curr.left;
            }
            else{
                prev.right=null;
                curr=curr.right;

            }
        }
       } 
       return ans;
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
    //    List<Integer> preorder= new ArrayList<>();
       
    //    if(root==null) return preorder;
    //    Stack<TreeNode> st= new Stack<>();

    //    st.push(root);
    //    while(!st.empty()){
    //         root=st.pop();
    //         preorder.add(root.val);
    //         if(root.right!=null){
    //             st.push(root.right);
    //         }
    //         if(root.left!=null){
    //             st.push(root.left);
    //         }
    //    }
    //    return preorder;
    ArrayList<Integer> ans=new ArrayList<>();
    return ans=MorrisPreorder(root);
}
}