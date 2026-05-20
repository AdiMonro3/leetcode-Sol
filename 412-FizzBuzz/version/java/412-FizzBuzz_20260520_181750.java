// Last updated: 20/05/2026, 18:17:50
1class Solution {
2    public List<String> fizzBuzz(int n) {
3
4        List<String> ans = new ArrayList<>();
5
6        for (int i = 1; i <= n; i++) {
7
8            if (i % 3 == 0 && i % 5 == 0) {
9                ans.add("FizzBuzz");
10            }
11            else if (i % 3 == 0) {
12                ans.add("Fizz");
13            }
14            else if (i % 5 == 0) {
15                ans.add("Buzz");
16            }
17            else {
18                ans.add(String.valueOf(i));
19            }
20        }
21
22        return ans;
23    }
24}