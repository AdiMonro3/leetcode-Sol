// Last updated: 16/10/2025, 15:57:20
class Solution {
    int dp[][];
    public int helper(int [] arr,int i,int j){
        if(j-i<=1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int res=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int temp=helper(arr,i,k)+arr[i]*arr[k]*arr[j]+helper(arr,k,j);
            res=Math.min(res,temp);
        }
        return dp[i][j]=res;
    }
    public int minScoreTriangulation(int[] values) {
        int n=values.length;
        dp=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(values,0,values.length-1);
    }
}