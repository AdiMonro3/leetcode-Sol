// Last updated: 18/02/2026, 18:38:17
1class Solution {
2    public boolean hasAlternatingBits(int n) {
3        int x = n ^ (n >> 1);
4        return (x & (x + 1)) == 0;
5    }
6}