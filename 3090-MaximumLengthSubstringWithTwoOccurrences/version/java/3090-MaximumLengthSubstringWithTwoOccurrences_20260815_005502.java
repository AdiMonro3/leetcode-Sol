// Last updated: 15/08/2026, 00:55:02
1class Solution {
2    public int maximumLengthSubstring(String s) {
3        int[] charCounts = new int[26];
4        int left = 0;
5        int maxLen = 0;
6        
7        for (int right = 0; right < s.length(); right++) {
8            // Map character to an index from 0 to 25
9            int rightCharIdx = s.charAt(right) - 'a';
10            charCounts[rightCharIdx]++;
11            
12            // Shrink the window if the current character exceeds 2 occurrences
13            while (charCounts[rightCharIdx] > 2) {
14                int leftCharIdx = s.charAt(left) - 'a';
15                charCounts[leftCharIdx]--;
16                left++;
17            }
18            
19            // Track the maximum valid window size
20            maxLen = Math.max(maxLen, right - left + 1);
21        }
22        
23        return maxLen;
24    }
25}