// Last updated: 29/09/2025, 15:54:31
class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1) return "";  // not possible

        char[] arr = palindrome.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            if (arr[i] != 'a') {
                arr[i] = 'a';
                return new String(arr);
            }
        }

        // all 'a's in first half, change last char to 'b'
        arr[n - 1] = 'b';
        return new String(arr);
    }
}

     