// Last updated: 20/02/2026, 14:49:19
1class Solution {
2    public String multiply(String num1, String num2) {
3        // 🔴 Edge case: if any number is 0
4        if (num1.equals("0") || num2.equals("0")) return "0";
5
6        int m = num1.length();
7        int n = num2.length();
8
9        // 🧱 Result array to store digits
10        int[] result = new int[m + n];
11
12        // 🔁 Multiply from right to left (like school math)
13        for (int i = m - 1; i >= 0; i--) {
14            for (int j = n - 1; j >= 0; j--) {
15
16                // Convert char to digit
17                int digit1 = num1.charAt(i) - '0';
18                int digit2 = num2.charAt(j) - '0';
19
20                int product = digit1 * digit2;
21
22                // 🎯 Correct positions
23                int pos2 = i + j + 1; // ones place
24                int pos1 = i + j;     // carry place
25
26                // Add to existing value
27                int sum = product + result[pos2];
28
29                result[pos2] = sum % 10;   // store digit
30                result[pos1] += sum / 10;  // carry
31            }
32        }
33
34        // 🧹 Build final string (skip leading zeros)
35        StringBuilder sb = new StringBuilder();
36
37        for (int num : result) {
38            if (!(sb.length() == 0 && num == 0)) {
39                sb.append(num);
40            }
41        }
42
43        return sb.toString();
44    }
45}