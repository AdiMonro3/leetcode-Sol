// Last updated: 07/08/2026, 22:44:46
1import java.util.List;
2
3class Solution {
4    public int helper(List<String> arr, int n, int i, StringBuilder sb) {
5        if (i >= n) return 0;
6
7        // Option 1: Do not pick the current string (Always a valid option)
8        int notpick = helper(arr, n, i + 1, sb);
9
10        // Option 2: Try to pick the current string
11        int pick = 0;
12        String currentStr = arr.get(i);
13        
14        // 1. Check if the string itself has unique characters AND fits in sb
15        if (isUniqueAndFits(currentStr, sb)) {
16            int len = currentStr.length();
17            
18            // 2. Choose: Append the string
19            sb.append(currentStr);
20            
21            // 3. Explore next steps
22            pick = len + helper(arr, n, i + 1, sb);
23            
24            // 4. Backtrack: Undo the append for the next recursive branches
25            sb.setLength(sb.length() - len);
26        }
27
28        return Math.max(pick, notpick);
29    }
30
31    // Helper method to check for duplicates within the string and against the SB
32    private boolean isUniqueAndFits(String s, StringBuilder sb) {
33        boolean[] seen = new boolean[26];
34        
35        // Check for internal duplicates within the string itself
36        for (int j = 0; j < s.length(); j++) {
37            int idx = s.charAt(j) - 'a';
38            if (seen[idx]) return false; 
39            seen[idx] = true;
40        }
41        
42        // Check if any character already exists in the StringBuilder
43        for (int j = 0; j < s.length(); j++) {
44            if (sb.indexOf(String.valueOf(s.charAt(j))) != -1) {
45                return false; 
46            }
47        }
48        
49        return true;
50    }
51
52    public int maxLength(List<String> arr) {
53        int n = arr.size();
54        StringBuilder sb = new StringBuilder();
55        return helper(arr, n, 0, sb);
56    }
57}
58