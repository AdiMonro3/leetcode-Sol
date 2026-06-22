// Last updated: 22/06/2026, 15:37:59
1class Solution {
2    public int maxNumberOfBalloons(String text) {
3        int[] count = new int[26];
4
5        for (char ch : text.toCharArray()) {
6            count[ch - 'a']++;
7        }
8
9        return Math.min(
10                Math.min(count['b' - 'a'], count['a' - 'a']),
11                Math.min(
12                        Math.min(count['l' - 'a'] / 2, count['o' - 'a'] / 2),
13                        count['n' - 'a']
14                )
15        );
16    }
17}