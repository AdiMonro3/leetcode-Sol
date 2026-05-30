// Last updated: 30/05/2026, 13:42:18
1class Solution {
2    public boolean isAdjacentDiffAtMostTwo(String s) {
3        int n=s.length();
4        for(int i=0;i<n-1;i++){
5            int x=s.charAt(i)-'0';
6            int y=s.charAt(i+1)-'0';
7
8            if(Math.abs(x-y)>2) return false;
9        }
10        return true;
11    }
12}