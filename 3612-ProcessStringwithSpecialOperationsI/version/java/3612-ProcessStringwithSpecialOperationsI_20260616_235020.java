// Last updated: 16/06/2026, 23:50:20
1class Solution {
2    public String processStr(String s) {
3        StringBuilder result = new StringBuilder();
4
5        for (char ch : s.toCharArray()) {
6
7            if (Character.isLowerCase(ch)) {
8                result.append(ch);
9            }
10            else if (ch == '*') {
11                if (result.length() > 0) {
12                    result.deleteCharAt(result.length() - 1);
13                }
14            }
15            else if (ch == '#') {
16                result.append(result.toString());
17            }
18            else if (ch == '%') {
19                result.reverse();
20            }
21        }
22
23        return result.toString();
24    }
25}