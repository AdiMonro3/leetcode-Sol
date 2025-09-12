// Last updated: 13/09/2025, 01:52:39
class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        int sign = 1;
        int result = 0;
        
        // Step 1: Ignore leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        // Step 2: Check for sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        
        // Step 3: Convert digits to number
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Step 4: Handle overflow cases
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }
        
        return result * sign;
    }
}
    