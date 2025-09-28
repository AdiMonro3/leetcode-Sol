// Last updated: 28/09/2025, 16:56:04
class Solution {
    int [][] dp;
    public int helper(int[] arr,int i,int j){
        if(i>j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int result=Integer.MIN_VALUE;
        for(int k=i+1;k<j;k++){
            int temp=arr[i] * arr[k] * arr[j]+helper(arr,i,k)+helper(arr,k,j);
            result=Math.max(result,temp);
        }
        return  dp[i][j] =result;
    }
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        for(int i=0;i<n;i++){
            arr[i+1]=nums[i];
        }
        int m=arr.length;
        dp=new int[m][m];
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<m;j++){
        //         dp[i][j]=-1;
        //     }
        // }
        // return helper(arr,0,m-1);
        for (int i = m-1; i >= 0; i--) {
            for (int j = 0; j <m; j++) {
                if(i>j) continue;
                int result=0;
                for(int k=i+1;k<j;k++){
                    int temp=arr[i] * arr[k] * arr[j]+dp[i][k]+dp[k][j];
                    result=Math.max(result,temp);
                }
               dp[i][j] =result;
            }
        }
        return dp[0][m-1];
    }
}