// Last updated: 13/09/2025, 01:51:42
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
    public ArrayList<Integer> Morrisinorder(TreeNode root){
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
                    prev.right=curr;
                    curr=curr.left;
                }
                else{
                    prev.right=null;
                    ans.add(curr.val);
                    curr=curr.right;

                }
            }
        }
        return ans;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        //recursive inorder traversal
        // List<Integer> inorder= new ArrayList<>();
        // Stack<TreeNode> st= new Stack<>();
        // TreeNode temp=root;
        // while(temp != null || !st.isEmpty()){
        //     if(temp!=null){
        //         st.push(temp);
        //         temp=temp.left;
        //     }
        //     else{
        //         temp=st.pop();
        //         inorder.add(temp.val);
        //         temp=temp.right;
        //     }
        // }
        // return inorder;
        ArrayList<Integer> ans=new ArrayList<>();
        ans=Morrisinorder(root);
        return ans;

    }
}