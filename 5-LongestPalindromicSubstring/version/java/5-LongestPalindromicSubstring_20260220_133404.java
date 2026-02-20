// Last updated: 20/02/2026, 13:34:04
1class Solution {
2
3    public String longestPalindrome(String s) {
4         if (s == null || s.length() < 1) return "";
5
6        int start = 0, end = 0;
7
8        for (int i = 0; i < s.length(); i++) {
9
10            int len1 = expand(s, i, i);       // odd length
11            int len2 = expand(s, i, i + 1);   // even length
12
13            int len = Math.max(len1, len2);
14
15            if (len > end - start + 1) {
16                start = i - (len - 1) / 2;
17                end = i + len / 2;
18            }
19        }
20
21        return s.substring(start, end + 1);
22    }
23
24    private int expand(String s, int left, int right) {
25        while (
26            left >= 0 &&
27            right < s.length() &&
28            s.charAt(left) == s.charAt(right)
29        ) {
30            left--;
31            right++;
32        }
33        return right - left - 1;
34    }
35}    