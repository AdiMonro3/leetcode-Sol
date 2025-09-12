// Last updated: 13/09/2025, 01:49:48
class Solution {
    public int firstUniqChar(String s) {
         int[] count = new int[26]; // For lowercase letters a-z

        // Step 1: Count frequency
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Step 2: Find first unique character
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1; 
    }
}