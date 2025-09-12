// Last updated: 13/09/2025, 01:49:43
class Solution {
    public int longestPalindrome(String s) {
         HashMap<Character, Integer> freq = new HashMap<>();

        // Step 1: Count frequency of each character
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int length = 0;
        boolean hasOdd = false;

        // Step 2: Use even parts, allow one odd for the center
        for (int count : freq.values()) {
            length += (count / 2) * 2; // add the even part
            if (count % 2 != 0) hasOdd = true; // mark if any odd count exists
        }

        // Step 3: Add 1 if there's an odd count (center character)
        if (hasOdd) length += 1;

        return length;
    }
}