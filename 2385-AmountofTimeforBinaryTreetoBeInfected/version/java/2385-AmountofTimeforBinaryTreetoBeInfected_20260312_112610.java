// Last updated: 12/03/2026, 11:26:10
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
16class Solution {
17    static HashMap<TreeNode,TreeNode> map=new HashMap<>();
18    static HashSet<TreeNode> visited = new HashSet<>();
19    static TreeNode start;
20    public static void helper(TreeNode root,TreeNode parent,int startVal){
21        if(root==null) return ;
22        if(root.val == startVal){
23            start = root;
24        }
25
26        map.put(root,parent);
27
28        helper(root.left,root,startVal);
29        helper(root.right,root,startVal);
30
31    }
32    public static int helper2(TreeNode root){
33        if(root==null || visited.contains(root)) return 0;
34        visited.add(root);
35        int up=helper2(map.get(root));
36
37        int left=helper2(root.left);
38        int right=helper2(root.right);
39
40        return 1+Math.max(up,Math.max(left,right));
41    }
42    public static int amountOfTime(TreeNode root, int strt) {
43        helper(root,null,strt);
44
45        return helper2(start)-1;
46    }
47}