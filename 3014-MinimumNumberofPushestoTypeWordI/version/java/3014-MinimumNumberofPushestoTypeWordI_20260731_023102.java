// Last updated: 31/07/2026, 02:31:02
1class Solution {
2    public int minimumPushes(String word) {
3        int n = word.length();
4        int blocks = n / 8;
5        return (blocks * (blocks + 1) * 4)
6                + (n % 8) * (blocks + 1);
7    }
8}