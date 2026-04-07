// Last updated: 07/04/2026, 16:45:06
1class Solution {
2    public int jump(int[] nums) {
3        int jumps = 0;
4        int curEnd = 0;
5        int curFarthest = 0;
6
7        for (int i = 0; i < nums.length - 1; i++) {
8            curFarthest = Math.max(curFarthest, i + nums[i]);
9
10            if(curFarthest>=nums.length-1) return jumps+1;
11            
12            if (i == curEnd) {
13                jumps++;
14                curEnd = curFarthest;
15            }
16        }
17
18        return jumps;
19    }
20}