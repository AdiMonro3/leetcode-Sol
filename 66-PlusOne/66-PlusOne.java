// Last updated: 13/09/2025, 01:51:57
class Solution {
    public int[] plusOne(int[] digits) {
int n = digits.length;

        // Traverse the digits array from the end
        for (int i = n - 1; i >= 0; i--) {
            // If current digit is less than 9, just increment it and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // Otherwise set it to 0 and continue to next digit
            digits[i] = 0;
        }

        // If all digits were 9, we need an extra digit at the beginning
        int[] result = new int[n + 1];
        result[0] = 1;  // e.g., 999 + 1 = 1000
        return result;
    }
}