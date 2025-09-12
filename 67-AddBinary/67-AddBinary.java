// Last updated: 13/09/2025, 01:51:55
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        // Loop through both strings from end to start
        while (i >= 0 || j >= 0 || carry != 0) {
            int bitA = (i >= 0) ? a.charAt(i) - '0' : 0;
            int bitB = (j >= 0) ? b.charAt(j) - '0' : 0;

            int sum = bitA + bitB + carry;
            result.append(sum % 2);         // add the binary digit
            carry = sum / 2;                // update carry

            i--;
            j--;
        }

        return result.reverse().toString();
    }
}