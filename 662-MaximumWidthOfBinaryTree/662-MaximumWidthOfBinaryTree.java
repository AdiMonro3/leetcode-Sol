// Last updated: 13/09/2025, 01:48:48
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
    public static class pair{
        int position;
        TreeNode node;
        public pair(TreeNode node,int position){
            this.position=position;
            this.node=node;
        }
    }
    public static int helper(TreeNode root){
        Queue<pair> que=new LinkedList<>();
        que.offer(new pair(root,0));
        int ans=0;
        while(!que.isEmpty()){
            int first=0;
            int last=0;
            int min=que.peek().position;
            int size=que.size();
            for(int i=0;i<size;i++){
                int id=que.peek().position-min;
                TreeNode node=que.peek().node;
                que.poll();

                if(i==0) first=id;
                if(i==size-1) last=id;

                if (node.left != null) {
                    que.add(new pair(node.left, id * 2 + 1));
                }
                if (node.right != null) {
                    que.add(new pair(node.right, id * 2 + 2));
                }
            }
            if(last-first+1>ans){
                ans=last-first+1;
            }
        }
        return ans;
    }
    public int widthOfBinaryTree(TreeNode root) {
        return helper(root);
    }
}