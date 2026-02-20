// Last updated: 20/02/2026, 13:58:20
1class Solution {
2    public String convert(String s, int numRows) {
3        // 🔴 Edge case:
4        // If only 1 row OR string length <= numRows,
5        // zigzag pattern doesn't change anything.
6        if (numRows == 1 || s.length() <= numRows) return s;
7
8        // 🧱 Create an array of StringBuilders.
9        // Each index represents one row of the zigzag.
10        StringBuilder[] rows = new StringBuilder[numRows];
11
12        // Initialize each row container
13        for (int i = 0; i < numRows; i++) {
14            rows[i] = new StringBuilder();
15        }
16
17        // 📍 currRow → tells which row we are currently filling
18        int currRow = 0;
19
20        // 🔄 goingDown → direction flag
21        // true  = moving downward
22        // false = moving upward
23        boolean goingDown = false;
24
25        // 🚶 Traverse each character of the string
26        for (char c : s.toCharArray()) {
27
28            // ✍️ Put current character into the current row
29            rows[currRow].append(c);
30
31            // 🔁 If we reach the top OR bottom row,
32            // we need to reverse direction.
33            if (currRow == 0 || currRow == numRows - 1) {
34                goingDown = !goingDown;
35            }
36
37            // ⬇️⬆️ Move to next row based on direction
38            if (goingDown) {
39                currRow++;   // move down
40            } else {
41                currRow--;   // move up
42            }
43        }
44
45        // 🧩 Combine all rows into final answer
46        StringBuilder result = new StringBuilder();
47        for (StringBuilder row : rows) {
48            result.append(row);
49        }
50
51        // ✅ Final zigzag string
52        return result.toString();
53    }
54}