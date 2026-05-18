// Last updated: 19/05/2026, 01:30:08
1class Solution {
2    public int countSegments(String s) {
3        int count = 0;
4        
5        for (int i = 0; i < s.length(); i++) {
6            // start of a word
7            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
8                count++;
9            }
10        }
11        
12        return count;
13    }
14}