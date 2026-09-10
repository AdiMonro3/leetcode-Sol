// Last updated: 11/09/2026, 00:30:32
1class Solution {
2    public String shiftingLetters(String s, int[][] shifts) {
3        int n = s.length();
4        int[] diff = new int[n]; // Difference array with size n
5
6        // Step 1: Populate the difference array
7        for (int[] shift : shifts) {
8            int start = shift[0];
9            int end = shift[1];
10            int direction = shift[2];
11
12            if (direction == 1) { // Forward shift
13                diff[start] += 1;
14                if (end + 1 < n) {
15                    diff[end + 1] -= 1;
16                }
17            } else { // Backward shift
18                diff[start] -= 1;
19                if (end + 1 < n) {
20                    diff[end + 1] += 1;
21                }
22            }
23        }
24
25        // Step 2: Compute the prefix sum to get the net shifts for each character
26        for (int i = 1; i < n; i++) {
27            diff[i] += diff[i - 1]; // Add the value from the previous index
28        }
29
30        // Step 3: Apply the shifts to the string
31        StringBuilder result = new StringBuilder(s);
32        for (int i = 0; i < n; i++) {
33            int shift = diff[i] % 26; // Ensure shift is within the range [0, 25]
34            if (shift < 0) {
35                shift += 26; // Handle negative shifts (backward)
36            }
37
38            // Apply the shift to character
39            char newChar = (char) (((result.charAt(i) - 'a' + shift) % 26) + 'a');
40            result.setCharAt(i, newChar);
41        }
42
43        return result.toString();
44    }
45}