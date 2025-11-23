// Last updated: 23/11/2025, 15:45:54
class Solution {
    int [][] dp;
    public int helper(int[] arr,int i,int j){
        // Base Case: If there are no balloons between i and j (e.g., adjacent indices),
        // we can't burst anything. 0 coins.
        if (i + 1 == j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int result=Integer.MIN_VALUE;
        for(int k=i+1;k<j;k++){
            // 1. If 'k' is the LAST balloon to burst, then by the time we pop it,
            //    all other balloons between i and j are already gone.
            //    So, 'k's direct neighbors become the walls 'i' and 'j'.
            //    Coins gained = left_wall * balloon_k * right_wall
            int costOfBurstingKLast = arr[i] * arr[k] * arr[j];

            // 2. Since 'k' is last, we must have already solved the sub-problems:
            //    - Everything to the Left of k (between i and k)
            //    - Everything to the Right of k (between k and j)
            int remainingCoins = helper(arr, i, k) + helper(arr, k, j);

            // Total coins for this choice of k
            int total = costOfBurstingKLast + remainingCoins;

            // Keep the maximum result found so far
            result = Math.max(result, total);
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