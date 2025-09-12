// Last updated: 13/09/2025, 01:49:46
class Solution {
    public char findTheDifference(String s, String t) {
         char result = 0;

        for (char c : s.toCharArray()) {
            result ^= c;
        }

        for (char c : t.toCharArray()) {
            result ^= c;
        }

        return result;
        
    }
}