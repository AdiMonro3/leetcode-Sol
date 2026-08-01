// Last updated: 01/08/2026, 23:21:41
1class Solution {
2    public long minInitialStrength(int[] monsters, int[][] boosts) {
3        int n=monsters.length;
4        long[] diff =new long[n+1];
5        
6        for(int[]b:boosts){
7            int l=b[0],r=b[1];
8            long v=b[2];
9            diff[l]+=v;
10            diff[r+1]-=v;
11            
12        }
13        long[] bonus=new long[n];
14        long running = 0;
15        for(int i=0;i<n;i++){
16            running+=diff[i];
17            bonus[i]=running;
18        }
19        long need=0;
20        for(int i=n-1;i>=0;i--){
21            long m=monsters[i];
22            long toBeatItNow=m-bonus[i];
23            long toSurviveRest=(need>0)?m+need:0;
24
25            need=Math.max(0,Math.max(toBeatItNow,toSurviveRest));
26        }
27        return need;
28    }
29}