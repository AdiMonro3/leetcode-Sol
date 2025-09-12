// Last updated: 13/09/2025, 01:50:07
class Solution {
    public boolean wordPattern(String pattern, String s) {
         String[] words = s.split(" ");
        if (pattern.length() != words.length)
            return false;

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(ch)) {
                if (!charToWord.get(ch).equals(word))
                    return false;
            } else {
                if (wordToChar.containsKey(word))
                    return false;
                charToWord.put(ch, word);
                wordToChar.put(word, ch);
            }
        }

        return true;
    }
}