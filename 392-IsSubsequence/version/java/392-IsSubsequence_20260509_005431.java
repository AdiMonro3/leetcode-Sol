// Last updated: 09/05/2026, 00:54:31
1class Solution {
2    public boolean isSubsequence(String s, String t) {
3        int i = 0, j = 0;
4
5    while (i < s.length() && j < t.length()) {
6        if (s.charAt(i) == t.charAt(j)) {
7            i++;
8        }
9        j++;
10    }
11
12    return i == s.length();
13    }
14}