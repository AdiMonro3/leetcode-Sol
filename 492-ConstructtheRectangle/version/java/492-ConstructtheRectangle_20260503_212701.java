// Last updated: 03/05/2026, 21:27:01
1class Solution {
2    public int[] constructRectangle(int area) {
3        int w = (int)Math.sqrt(area);
4        
5        while (area % w != 0) {
6            w--;
7        }
8        
9        int l = area / w;
10        return new int[]{l, w};
11    }
12}