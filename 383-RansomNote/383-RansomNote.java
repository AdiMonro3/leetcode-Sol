// Last updated: 13/09/2025, 01:49:50
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26]; // for a-z

        // Count characters in magazine
        for (char c : magazine.toCharArray()) {
            letters[c - 'a']++;
        }

        // Check if ransomNote can be formed
        for (char c : ransomNote.toCharArray()) {
            if (letters[c - 'a'] == 0) {
                return false; // not enough characters
            }
            letters[c - 'a']--;
        }

        return true;
    }
}