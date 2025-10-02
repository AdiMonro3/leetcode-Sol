// Last updated: 02/10/2025, 19:59:01
class Solution {
    int[][] dp;
    public int eggDrop(int eggs, int floors) {
        // Base cases
        if (floors == 0 || floors == 1) return floors; // 0 floors -> 0 attempts, 1 floor -> 1 attempt
        if (eggs == 1) return floors; // with 1 egg -> check floors linearly

        int minAttempts = Integer.MAX_VALUE;
         if (dp[eggs][floors] != -1) return dp[eggs][floors];
        // Try dropping from each floor 1..floors
        for (int k = 1; k <= floors; k++) {
            int breaks = eggDrop(eggs - 1, k - 1); // egg breaks -> below floors
            int notBreaks = eggDrop(eggs, floors - k); // egg doesn't break -> above floors
            int worstCase = 1 + Math.max(breaks, notBreaks);

            minAttempts = Math.min(minAttempts, worstCase);
        }

        return dp[eggs][floors] = minAttempts;
    }
    public int superEggDrop(int k, int n) {
        //  dp = new int[k + 1][n + 1];
        //  for (int i = 0; i <= k; i++) {
        //     for (int j = 0; j <= n; j++) {
        //         dp[i][j] = -1;
        //     }
        // }
        // return eggDrop(k,n);
        int[][] dp = new int[k + 1][n + 1];

        // Base cases
        for (int i = 1; i <= k; i++) { 
            dp[i][0] = 0; // 0 floors = 0 attempts
            dp[i][1] = 1; // 1 floor = 1 attempt
        }
        for (int j = 1; j <= n; j++) {
            dp[1][j] = j; // with 1 egg -> linear scan
        }

        // Fill DP table
        for (int e = 2; e <= k; e++) { // eggs
            for (int f = 2; f <= n; f++) { // floors
               int low = 1, high = f, result = Integer.MAX_VALUE;

                while (low <= high) {
                    int mid = (low + high) / 2;

                    int breaks = dp[e - 1][mid - 1];  // egg breaks
                    int notBreaks = dp[e][f - mid];   // egg survives

                    int worst = 1 + Math.max(breaks, notBreaks);
                    result = Math.min(result, worst);

                    // Binary search direction
                    if (breaks > notBreaks) {
                        high = mid - 1; // go down
                    } else {
                        low = mid + 1;  // go up
                    }
                }

                dp[e][f] = result;
            }
        }

        return dp[k][n];
    }
}