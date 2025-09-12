// Last updated: 13/09/2025, 01:47:54
class Solution {
    private static int longestCommonSubseq(String s1, String s2, int i, int j, Integer[][] dp) {
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != null) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + longestCommonSubseq(s1, s2, i - 1, j - 1, dp);
        } else {
            return dp[i][j] = Math.max(
                longestCommonSubseq(s1, s2, i - 1, j, dp),
                longestCommonSubseq(s1, s2, i, j - 1, dp)
            );
        }
    }

    public int minInsertions(String s) {
        //  int n = s.length();
        // String rev = new StringBuilder(s).reverse().toString();
        // Integer[][] dp = new Integer[n][n];
        // int lpsLength = longestCommonSubseq(s, rev, n - 1, n - 1, dp);
        // return n - lpsLength;
         int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();

        int[][] dp = new int[n + 1][n + 1];

        // Fill the table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lps = dp[n][n];
        return n - lps;
    }
    }
