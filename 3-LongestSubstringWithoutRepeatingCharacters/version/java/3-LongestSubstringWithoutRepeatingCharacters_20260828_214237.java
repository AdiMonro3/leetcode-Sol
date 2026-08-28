// Last updated: 28/08/2026, 21:42:37
1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3       
4        int i = 0; 
5        int len = 0; 
6        int[] freq = new int[128]; 
7        
8        for (int j = 0; j < s.length(); j++) {
9            char ch = s.charAt(j);
10            if (freq[ch] > 0) {
11                i = Math.max(i, freq[ch]); 
12            }
13            freq[ch] = j + 1;
14            len = Math.max(len, j - i + 1);
15        }
16        
17        return len;
18    
19
20    }
21}