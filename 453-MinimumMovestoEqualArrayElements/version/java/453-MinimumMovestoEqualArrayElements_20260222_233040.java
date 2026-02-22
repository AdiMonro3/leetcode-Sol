// Last updated: 22/02/2026, 23:30:40
1class Solution {
2    public int minMoves(int[] nums) {
3        Arrays.sort(nums);
4        int smallest=nums[0];
5        int count=0;
6        for(int i=1;i<nums.length;i++){
7            int diff=Math.abs(smallest-nums[i]);
8            count+=diff;
9        }
10        return count;
11    }
12}