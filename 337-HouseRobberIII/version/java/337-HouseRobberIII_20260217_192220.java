// Last updated: 17/02/2026, 19:22:20
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
16 class Solution {
17
18    public int[] dfs(TreeNode root) {
19        if (root == null) return new int[]{0, 0};
20
21        int[] left = dfs(root.left);
22        int[] right = dfs(root.right);
23
24        int pick = root.val + left[0] + right[0];
25
26        int notPick = Math.max(left[0], left[1])
27                    + Math.max(right[0], right[1]);
28
29        return new int[]{notPick, pick};
30    }
31
32    public int rob(TreeNode root) {
33        int[] res = dfs(root);
34        return Math.max(res[0], res[1]);
35    }
36}
37