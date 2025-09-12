// Last updated: 13/09/2025, 01:51:35
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result= new ArrayList<>();
            if(root==null){
                return result;
            }
                // int index=0;
            Queue<TreeNode> queue= new LinkedList<>();
            queue.add(root);
            boolean lefttoright=true;
            while(!queue.isEmpty()){
                int size=queue.size();
                List<Integer> sublist= new ArrayList<>();
                for(int i=0;i<size;i++){
                    TreeNode node=queue.poll();
                 if (lefttoright == true) {
                   sublist.add(node.val); 
                } else {
                    sublist.add(0, node.val); 
                }

                    if(node.left!=null){
                        queue.add(node.left);
                    }
                    if(node.right!=null){
                        queue.add(node.right);
                    }   
                }
              
                result.add(sublist);
                lefttoright=!lefttoright;
                
            }
            return result;
        
    }
}