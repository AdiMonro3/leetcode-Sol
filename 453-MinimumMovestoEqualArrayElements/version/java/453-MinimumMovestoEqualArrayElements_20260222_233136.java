// Last updated: 22/02/2026, 23:31:36
1class Solution {
2    public int minMoves(int[] nums) {
3        int min = Integer.MAX_VALUE;
4        int count = 0;
5        for (int i=0; i<nums.length; i++) {
6            min = Math.min(min, nums[i]);
7        }
8        for (int i=0; i<nums.length; i++) {
9            count += Math.abs(min - nums[i]);
10        }
11        return count;
12    }
13}