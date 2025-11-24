// Last updated: 24/11/2025, 23:13:40
class Solution {
    Boolean[] dp;

    public boolean solve(String s, Set<String> dict, int start) {
        if (start == s.length()) return true;
        if (dp[start] != null) return dp[start];

        for (int end = start + 1; end <= s.length(); end++) {
            if (dict.contains(s.substring(start, end)) && solve(s, dict, end)) {
                return dp[start] = true;
            }
        }

        return dp[start] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()];
        return solve(s, new HashSet<>(wordDict), 0);
    }
}
