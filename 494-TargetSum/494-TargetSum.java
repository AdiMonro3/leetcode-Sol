// Last updated: 13/09/2025, 01:49:19
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total=0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        int [][] dp= new int[nums.length+1][total+1];
        for(int i=0;i<nums.length+1;i++){
            dp[i][0]=1;
        }
        for(int idx=1;idx<nums.length+1;idx++){
            for(int tar=0;tar<total+1;tar++){
                int notpick=dp[idx-1][tar];
                int pick=0;
                if(tar>=nums[idx-1]){
                    pick=dp[idx-1][tar-nums[idx-1]];
                }
                dp[idx][tar]=pick+notpick;
            }
        }
        int count=0;
        for(int j=0;j<total+1;j++){
            int s1=j;
            int s2=total-j;
            if(s1-s2==target) count+=dp[nums.length][j];
        }
        return count;
    }
}