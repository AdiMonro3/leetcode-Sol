// Last updated: 22/04/2026, 19:19:31
1class Solution {
2    public boolean isLongPressedName(String name, String typed) {
3        int i = 0, j = 0;
4
5        while (j < typed.length()) {
6            
7            // case 1: characters match
8            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
9                i++;
10                j++;
11            }
12            // case 2: long press (repeat of previous char)
13            else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
14                j++;
15            }
16            // case 3: invalid
17            else {
18                return false;
19            }
20        }
21
22        // check if we used all characters of name
23        return i == name.length();
24        
25    }
26}