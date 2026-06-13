// Last updated: 14/06/2026, 02:23:26
1class Solution {
2    public String mapWordWeights(String[] words, int[] weights) {
3
4        StringBuilder ans = new StringBuilder();
5
6        for (String word : words) {
7
8            int sum = 0;
9
10            for (char ch : word.toCharArray()) {
11                sum += weights[ch - 'a'];
12            }
13
14            int mod = sum % 26;
15
16            ans.append((char) ('z' - mod));
17        }
18
19        return ans.toString();
20    }
21
22}