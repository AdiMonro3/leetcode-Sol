// Last updated: 13/09/2025, 01:49:12
class Solution {
    public int change(int T, int[] arr) {
        int n=arr.length;
           long dp[][] = new long[n][T + 1];
        for (int i = 0; i <= T; i++) {
            if (i % arr[0] == 0)
                dp[0][i] = 1;
            
        }

       
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= T; target++) {
                long notTaken = dp[ind - 1][target];

                long taken = 0;
                if (arr[ind] <= target)
                    taken = dp[ind][target - arr[ind]];

                dp[ind][target] = notTaken + taken;
            }
        }

        return (int)dp[n - 1][T];
    }

    }
