// Last updated: 18/08/2026, 01:09:49
1class Solution {
2    int[][] dp;
3    
4    public boolean helper(String s, String p, int i, int j) {
5        // Base case: both exhausted means a match
6        if (i >= s.length() && j >= p.length()) return true;
7        // Base case: pattern exhausted but string isn't means no match
8        if (j >= p.length()) return false;
9        
10        if (dp[i][j] != 0) {
11            return dp[i][j] == 1;
12        }
13
14        // Check if the current characters match
15        boolean firstMatch = (i < s.length() && 
16                             (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
17
18        boolean result = false;
19        
20        // If the NEXT character is a '*'
21        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
22            // We have two choices:
23            // 1. Skip the "char*" entirely (zero occurrences) -> j + 2
24            // 2. If firstMatch is true, use the '*' to consume one character in 's' -> i + 1
25            result = helper(s, p, i, j + 2) || (firstMatch && helper(s, p, i + 1, j));
26        } else {
27            // No '*', so it's a simple character-to-character match
28            result = firstMatch && helper(s, p, i + 1, j + 1);
29        }
30
31        dp[i][j] = result ? 1 : -1;
32        return result;
33    }
34    
35    public boolean isMatch(String s, String p) {
36        // Note: we need the matrix to be slightly larger to handle the base cases cleanly
37        // where i == s.length() but we still need to process remaining "a*b*" in the pattern
38        dp = new int[s.length() + 1][p.length() + 1];
39        return helper(s, p, 0, 0);
40    }
41}