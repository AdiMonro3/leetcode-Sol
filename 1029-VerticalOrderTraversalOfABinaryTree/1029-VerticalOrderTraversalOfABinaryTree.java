// Last updated: 13/09/2025, 01:48:16
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
    public static void helper(TreeNode root, HashMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>map,int vlevel,int hlevel){
        if(root==null) return ;
        map.computeIfAbsent(vlevel,k -> new TreeMap<>()).computeIfAbsent(hlevel,k -> new PriorityQueue<>()).add(root.val);
        helper(root.left,map,vlevel-1,hlevel+1);
        helper(root.right,map,vlevel+1,hlevel+1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new HashMap<>();
        helper(root,map,0,0);
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> columnkeys = new ArrayList<>(map.keySet());

        Collections.sort(columnkeys);
        for (int vertical : columnkeys) {
            TreeMap<Integer, PriorityQueue<Integer>> rowkeys = map.get(vertical);
            List<Integer> temp=new ArrayList<>();
            for (int row : rowkeys.keySet()) {
                PriorityQueue<Integer> nodes = rowkeys.get(row);
                while (!nodes.isEmpty()) {
                    temp.add(nodes.poll()); 
                }
            }
            result.add(temp);
        }
        return result;
    }
}