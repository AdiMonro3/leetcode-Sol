// Last updated: 25/03/2026, 01:07:05
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
17    TreeNode helper(int[] nums,int l,int r){
18        if(l>=r) return null;
19
20        int max=Integer.MIN_VALUE;
21        int maxIdx=-1;
22
23        for(int i=l;i<r;i++){
24            if(nums[i]>max){
25                max=nums[i];
26                maxIdx=i;
27            }
28        }
29
30        TreeNode root = new TreeNode(max);
31
32        // build left and right
33        root.left = helper(nums, l, maxIdx);
34        root.right = helper(nums, maxIdx + 1, r);
35
36        return root;
37
38    }
39    public TreeNode constructMaximumBinaryTree(int[] nums) {
40        int n=nums.length;
41        return helper(nums,0,n);
42    }
43}