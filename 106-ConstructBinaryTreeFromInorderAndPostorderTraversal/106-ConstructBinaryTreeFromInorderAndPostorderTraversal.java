// Last updated: 13/09/2025, 01:51:30
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
    public static TreeNode buildtree(int[]inorder,int inStart,int inEnd,int[] postorder,int postStart,int postEnd,HashMap<Integer,Integer> map){
        if(inStart>inEnd || postStart>postEnd) return null;
        TreeNode root=new TreeNode(postorder[postEnd]);
        int inidx=map.get(root.val);
        int size=inEnd - inidx;
        root.left=buildtree(inorder,inStart,inidx-1,postorder,postStart,postEnd-size-1,map);
        root.right=buildtree(inorder,inidx+1,inEnd,postorder,postEnd-size,postEnd-1,map);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root=buildtree(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);
        return root;
    }
}