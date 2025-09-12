// Last updated: 13/09/2025, 01:49:55
class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();

        // Define two pointers
        int left = 0, right = chars.length - 1;

        // Set of vowels (both lowercase and uppercase)
        Set<Character> vowels = new HashSet<>(Arrays.asList(
            'a','e','i','o','u','A','E','I','O','U'));

        // Two-pointer approach
        while (left < right) {
            while (left < right && !vowels.contains(chars[left])) left++;
            while (left < right && !vowels.contains(chars[right])) right--;

            // Swap vowels
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        // Convert back to string and return
        return new String(chars);
    }
}