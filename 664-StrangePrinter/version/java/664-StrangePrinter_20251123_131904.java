// Last updated: 23/11/2025, 13:19:04
class Solution {
    public int solve(String s, int i, int j, int[][] memo) {
        if (i == j) return 1;
        if (i > j) return 0;
        if (memo[i][j] != 0) return memo[i][j];

        // Option 1: Print current char alone (Baseline)
        int minturn = 1 + solve(s, i + 1, j, memo);

        // Option 2: Look for matches to merge strokes
        for (int k = i + 1; k <= j; k++) {
            if (s.charAt(i) == s.charAt(k)) {
                // The logic: match i and k, solve inside (i to k-1) + solve outside (k+1 to j)
                int turn = solve(s, i, k - 1, memo) + solve(s, k + 1, j, memo);
                minturn = Math.min(minturn, turn);
            }
        }
        return memo[i][j] = minturn;
    }

    public int strangePrinter(String s) {
        if (s.length() == 0) return 0;

        // --- OPTIMIZATION START ---
        // Compress the string: "aaabbbaac" -> "abac"
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Only add the character if it is the first one
            // OR if it is different from the previous one
            if (i == 0 || c != s.charAt(i - 1)) {
                sb.append(c);
            }
        }
        String optimizedS = sb.toString();
        // --- OPTIMIZATION END ---

        int n = optimizedS.length();
        int[][] memo = new int[n][n]; // Create memo table based on the NEW length
        
        // Pass the optimized string, not the original 's'
        return solve(optimizedS, 0, n - 1, memo);
    }
}