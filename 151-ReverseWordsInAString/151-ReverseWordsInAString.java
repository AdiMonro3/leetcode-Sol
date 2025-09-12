// Last updated: 13/09/2025, 01:51:04
class Solution {
    public String reverseWords(String s) {
      s = s.strip(); // Remove leading & trailing spaces
        int n = s.length();
        String ans = "";
        String temp = "";

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch != ' ') {
                temp = ch + temp; // Build the current word
            } 
            else if (!temp.isEmpty()) { 
                // Append the word only if it's not empty
                if (ans.isEmpty()) {
                    ans = temp;
                } else {
                    ans = ans + " " + temp;
                }
                temp = ""; // Reset temp for the next word
            }
        }

        // Add the last word
        if (!temp.isEmpty()) {
            if (ans.isEmpty()) {
                ans = temp;
            } else {
                ans = ans + " " + temp;
            }
        }

        return ans;
    }
}