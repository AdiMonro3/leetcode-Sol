// Last updated: 15/01/2026, 05:51:24
1class Solution {
2    int dp[];
3    public int houserob(int []nums,int i){
4        if(i>=nums.length)return 0;
5        if(dp[i]!=-1) return dp[i];
6        int pick=nums[i]+houserob(nums,i+2);
7        int notpick=houserob(nums,i+1);
8
9        return dp[i]=Math.max(pick,notpick);
10    }
11    public int rob(int[] nums) {
12        dp=new int[nums.length];
13        for(int i=0;i<nums.length;i++){
14            dp[i]=-1;
15        }
16        return houserob(nums,0);
17    }
18}