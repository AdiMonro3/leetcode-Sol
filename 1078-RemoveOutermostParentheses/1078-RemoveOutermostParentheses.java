// Last updated: 13/09/2025, 01:48:07
class Solution {
    public String removeOuterParentheses(String s) {
         StringBuilder result = new StringBuilder();
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ')') depth--; // Decrement before checking (to handle outer parentheses)
            if (depth > 0) result.append(ch);
            if (ch == '(') depth++; // Increment after checking
        }

        return result.toString();
    }
}