// Last updated: 31/01/2026, 15:15:43
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class FindElements {
17    HashSet<Integer> set=new HashSet<>();
18    public void helper(TreeNode root,int val){
19        if(root==null) return;
20
21        root.val=val;
22        set.add(val);
23        helper(root.left,2*val+1);
24        helper(root.right,2*val+2);
25
26    }
27    public FindElements(TreeNode root) {
28        helper(root,0);
29    }
30
31    
32    public boolean find(int target) {
33        if(set.contains(target)) return true;
34        else return false;
35    }
36}
37
38/**
39 * Your FindElements object will be instantiated and called as such:
40 * FindElements obj = new FindElements(root);
41 * boolean param_1 = obj.find(target);
42 */