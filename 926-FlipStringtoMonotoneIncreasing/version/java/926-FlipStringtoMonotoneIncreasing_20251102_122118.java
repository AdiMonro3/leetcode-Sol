// Last updated: 02/11/2025, 12:21:18
class Solution {
    int dp[][];
    public int helper(int [] arr,int n,int i,int time){
        if(i>=n) return 0;
        if(dp[i][time]!=-1) return dp[i][time];
        int pick= ( arr[i]*time ) + helper(arr,n,i+1,time+1);
        int notpick=helper(arr,n,i+1,time);

        return dp[i][time] = Math.max(pick,notpick);
    }
    public int maxSatisfaction(int[] satisfaction) {
        int n=satisfaction.length;
        Arrays.sort(satisfaction);
        dp=new int[n][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        return helper(satisfaction,n,0,1);
    }
}