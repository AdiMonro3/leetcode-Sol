// Last updated: 06/05/2026, 14:49:09
1class Solution {
2    public int addDigits(int num) {
3         return num == 0 ? 0 : 1 + (num - 1) % 9;
4    }
5}