// Last updated: 08/09/2026, 13:54:55
1class Solution {
2    public long countCommas(long n) {
3        if(n<1000) return 0;
4
5        long base=1000;
6        long commas=0;
7        while(n>=base){
8            commas+=(n-base+1);
9            base*=1000;
10        }
11        return commas;
12
13    }
14}