// Last updated: 17/09/2026, 22:56:58
1class Solution {
2    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
3        return rec1[0] < rec2[2] && rec2[0] < rec1[2] && 
4               rec1[1] < rec2[3] && rec2[1] < rec1[3];
5    }
6}