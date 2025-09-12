// Last updated: 13/09/2025, 01:49:11
class Solution {
    public boolean detectCapitalUse(String word) {
        
    return word.equals(word.toUpperCase()) ||         // Case 1: All uppercase
               word.equals(word.toLowerCase()) ||         // Case 2: All lowercase
               Character.isUpperCase(word.charAt(0)) &&   // Case 3: Only first capital
               word.substring(1).equals(word.substring(1).toLowerCase());
    }
}