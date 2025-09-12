// Last updated: 13/09/2025, 01:48:05
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
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> st=new Stack<>();
        char[] ch=traversal.toCharArray();
        int i=0;
        while(i<ch.length){
            int depth=0;
            while(i<ch.length && ch[i]=='-'){
                depth++;
                i++;
            }
            int value=0;
            while(i<ch.length && Character.isDigit(ch[i])){
                value = value * 10 + (ch[i] - '0');
                i++;
            }
            TreeNode root =new TreeNode(value);
             while (st.size() > depth) {
                st.pop();
            }
             if (!st.isEmpty()) {
                TreeNode parent = st.peek();
                if (parent.left == null) parent.left = root;
                else parent.right = root;
            }
                st.push(root);
        }
         while (st.size() > 1) st.pop();
        return st.peek();
    }
}