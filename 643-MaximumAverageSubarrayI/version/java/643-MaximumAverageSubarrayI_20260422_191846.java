// Last updated: 22/04/2026, 19:18:46
1class Solution {
2    public int numJewelsInStones(String jewels, String stones) {
3        Set<Character> set = new HashSet<>();
4
5        // store jewels
6        for (char c : jewels.toCharArray()) {
7            set.add(c);
8        }
9
10        int count = 0;
11
12        // count stones
13        for (char c : stones.toCharArray()) {
14            if (set.contains(c)) {
15                count++;
16            }
17        }
18
19        return count;
20    }
21}