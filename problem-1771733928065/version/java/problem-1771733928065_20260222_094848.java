// Last updated: 22/02/2026, 09:48:48
1class Solution {
2    public int scoreDifference(int[] nums) {
3        int score1=0;
4        int score2=0;
5
6        boolean active1=true;
7        for(int i=0;i<nums.length;i++){
8            if(nums[i]%2==1) active1=!active1;
9            if (i % 6 == 5) active1=!active1;
10
11            if(active1) score1+=nums[i];
12            else score2+=nums[i];
13        }
14        return score1-score2;
15    }
16}