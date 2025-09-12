// Last updated: 13/09/2025, 01:51:32
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
    public static TreeNode buildtree(int[]preorder,int prestart,int preEnd,int []inorder,int instart,int inEnd,HashMap<Integer, Integer> map){
        if (prestart > preEnd || instart > inEnd) {
            return null;
        }
        TreeNode node=new TreeNode(preorder[prestart]);
        int cod=map.get(node.val);
        int size=cod-instart;
        node.left=buildtree(preorder,prestart+1,prestart+size,inorder,instart,cod-1,map);
        node.right=buildtree(preorder,prestart+size+1,preEnd,inorder,cod+1,inEnd,map);
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<preorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root=buildtree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }
}