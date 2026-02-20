// Last updated: 20/02/2026, 14:44:50
1class Solution {
2    public String countAndSay(int n) {
3        // 🔹 Base case
4        String result = "1";
5
6        // 🔹 Build sequence from 2 → n
7        for (int i = 2; i <= n; i++) {
8
9            StringBuilder next = new StringBuilder();
10
11            int count = 1; // count of current character
12
13            // 🧠 Traverse current result string
14            for (int j = 1; j < result.length(); j++) {
15
16                // If same character, increase count
17                if (result.charAt(j) == result.charAt(j - 1)) {
18                    count++;
19                } 
20                // If different character, append previous group
21                else {
22                    next.append(count);                 // how many
23                    next.append(result.charAt(j - 1));  // which digit
24                    count = 1; // reset count
25                }
26            }
27
28            // 🔴 Important: append the last group
29            next.append(count);
30            next.append(result.charAt(result.length() - 1));
31
32            // Move to next iteration
33            result = next.toString();
34        }
35
36        return result;
37    }
38}