// Last updated: 13/09/2025, 01:51:36
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> resultlist = new ArrayList<>();
        
        if (root == null) return resultlist;

        queue.add(root); // Add the root to the queue
        while (!queue.isEmpty()) { // Process until the queue is empty
            int levelnum = queue.size(); // Number of nodes at the current level
            List<Integer> sublist = new ArrayList<>();

            // Iterate through nodes of the current level
            for (int i = 0; i < levelnum; i++) {
                TreeNode temp = queue.poll(); // Get and remove the front node
                
                // Add the value of the current node to the sublist
                sublist.add(temp.val);

                // Add the left and right children of the current node to the queue
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }

            // Add the current level's values to the result list
            resultlist.add(sublist);
        }
        
        return resultlist;
    }
}