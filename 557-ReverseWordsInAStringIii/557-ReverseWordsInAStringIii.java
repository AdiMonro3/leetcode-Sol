// Last updated: 13/09/2025, 01:48:59
class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            // Reverse each word
            StringBuilder sb = new StringBuilder(word);
            result.append(sb.reverse().toString()).append(" ");
        }

        // Remove the trailing space
        return result.toString().trim();
    }
}