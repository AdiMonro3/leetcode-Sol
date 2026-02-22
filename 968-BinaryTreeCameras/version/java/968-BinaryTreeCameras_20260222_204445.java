// Last updated: 22/02/2026, 20:44:45
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
17    // 0 means covered without camera
18    // 1 means covered with camera
19    // -1 means not covered
20    int count=0;
21    public int dfs(TreeNode root){
22        if(root==null) return 0;
23        int left=dfs(root.left);
24        int right=dfs(root.right);
25
26        if(left==-1 || right==-1){
27            count++;
28            return 1;
29        } 
30        if(left==1 || right==1) {
31            return 0;
32        }
33        return -1;
34
35    }
36    public int minCameraCover(TreeNode root) {
37        if(dfs(root)==-1) count++;
38        return count;
39        
40    }
41}