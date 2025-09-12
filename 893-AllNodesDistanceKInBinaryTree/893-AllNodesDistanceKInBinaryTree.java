// Last updated: 13/09/2025, 01:48:27
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void findparent(TreeNode root,HashMap markparent){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left!=null){
                    markparent.put(node.left,node);
                    q.offer(node.left);
                }
                if(node.right!=null){
                    markparent.put(node.right,node);
                    q.offer(node.right);
                }
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parentmap=new HashMap<>();
        findparent(root,parentmap);
        HashSet<TreeNode> visited=new HashSet<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(target);
        visited.add(target);
        int distance=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(distance==k) break;
            distance++;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                TreeNode parent=parentmap.get(node);
                if(node.left!=null && visited.contains(node.left)==false){
                    q.offer(node.left);
                    visited.add(node.left);
                }
                if(node.right!=null && visited.contains(node.right)==false){
                    q.offer(node.right);
                    visited.add(node.right);
                }
                if(parent!=null && visited.contains(parent)==false){
                    q.offer(parent);
                    visited.add(parent);
                }
            }
            
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            ans.add(node.val);
        }
        return ans;
    }
}