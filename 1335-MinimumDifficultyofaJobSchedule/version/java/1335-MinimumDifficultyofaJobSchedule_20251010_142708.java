// Last updated: 10/10/2025, 14:27:08
class Solution {
    public int helper(int [] nums,int d, int i,int[][] dp){
        if(d==1){
            int max=Integer.MIN_VALUE;
            for(int j=i;j<nums.length;j++){
                max=Math.max(max,nums[j]);
            }
            return max;
        }
        if (dp[i][d] != -1) return dp[i][d];
        int maxd=Integer.MIN_VALUE;
        int fres=Integer.MAX_VALUE;
        for(int k=i;k<nums.length-(d-1);k++){
            maxd=Math.max(nums[k],maxd);
            int res=maxd+helper(nums,d-1,k+1,dp);
            fres=Math.min(fres,res);
        }
        return dp[i][d] = fres;

    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty.length<d) return -1;
        int[][] dp = new int[jobDifficulty.length][d + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(jobDifficulty,d,0,dp);
    }
}