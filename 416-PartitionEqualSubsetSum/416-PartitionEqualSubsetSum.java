// Last updated: 13/09/2025, 01:49:37
class Solution {
    public static boolean subsetsum(int [] nums,int n,int sum,int idx,int dp[][]){
        if(sum==0) return true;

        if(idx==0){
            if(nums[idx]==sum) return true;

            else return false;
        }
        if(dp[idx][sum]!=-1){
            if(dp[idx][sum]==1) return true;

            else return false;
        }
        boolean nottake=subsetsum(nums,n,sum,idx-1,dp);
        boolean take=false;
        if(sum>=nums[idx]){
            take=subsetsum(nums,n,sum-nums[idx],idx-1,dp);
        }

        if(take||nottake){
            dp[idx][sum]=1;
        }
        else dp[idx][sum]=0;

        return take||nottake;


    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int t = sum / 2;
        boolean [][] dp=new boolean[n+1][t+1];
        for (int i = 0; i <= n; i++) {
          dp[i][0] = true;
    }
        for(int i=1;i<n+1;i++){
            for(int target=0;target<t+1;target++){
                boolean nottake=dp[i-1][target];
                boolean take=false;
                if(target>=nums[i-1]){
                    take=dp[i-1][target-nums[i-1]];
                }

                dp[i][target]=take||nottake;
                }
            }

        return dp[n][t];

    }
}