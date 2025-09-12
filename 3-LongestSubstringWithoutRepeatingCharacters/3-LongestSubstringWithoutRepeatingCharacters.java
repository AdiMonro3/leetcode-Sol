// Last updated: 13/09/2025, 01:52:43
class Solution {
    public int lengthOfLongestSubstring(String s) {
       
        int i = 0; 
        int len = 0; 
        int[] freq = new int[128]; 
        
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (freq[ch] > 0) {
                i = Math.max(i, freq[ch]); 
            }
            freq[ch] = j + 1;
            len = Math.max(len, j - i + 1);
        }
        
        return len;
    

    }
}