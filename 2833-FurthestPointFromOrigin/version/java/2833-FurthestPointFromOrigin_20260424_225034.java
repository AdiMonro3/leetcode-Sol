// Last updated: 24/04/2026, 22:50:34
1class Solution {
2    public int furthestDistanceFromOrigin(String moves) {
3        int left = 0, right = 0, blank = 0;
4
5        for (char ch : moves.toCharArray()) {
6            if (ch == 'L') left++;
7            else if (ch == 'R') right++;
8            else blank++; // '_'
9        }
10
11        return Math.abs(left - right) + blank;
12    }
13}