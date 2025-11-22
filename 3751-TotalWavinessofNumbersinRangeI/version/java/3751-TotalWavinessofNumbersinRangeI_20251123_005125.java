// Last updated: 23/11/2025, 00:51:25
class Solution {
    public int totalWaviness(int start, int end) {
        int totalSum = 0;

        for (int num = start; num <= end; num++) {
            char[] digits = String.valueOf(num).toCharArray();

            // Skip numbers with less than 3 digits (no internal peaks/valleys possible)
            if (digits.length < 3) continue;

            for (int i = 1; i < digits.length - 1; i++) {
                int left = digits[i - 1] - '0';
                int mid = digits[i] - '0';
                int right = digits[i + 1] - '0';

                // Peak check
                if (mid > left && mid > right) {
                    totalSum ++;
                }
                // Valley check
                else if (mid < left && mid < right) {
                    totalSum ++;
                }
            }
        }

        return totalSum;
    }
}