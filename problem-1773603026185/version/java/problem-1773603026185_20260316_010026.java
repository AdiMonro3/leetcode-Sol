// Last updated: 16/03/2026, 01:00:26
1class Solution {
2    public long countCommas(long n) {
3        long ans=0;
4
5        long start=1000;
6
7        int comma=1;
8
9        while(start<=n){
10            long end=start*1000-1;
11            long count=Math.min(n,end)-start+1;
12
13            if(count>0){
14                ans+=count*comma;
15            }
16
17            start*=1000;
18            comma++;
19        }
20
21        return ans;
22    }
23}