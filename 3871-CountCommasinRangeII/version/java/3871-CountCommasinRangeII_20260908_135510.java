// Last updated: 08/09/2026, 13:55:10
1class Solution {
2    long c1=1000;
3    long c2=1000000;
4    long c3=1000000000;
5    long c4=1000000000000L;
6    long c5=1000000000000000L;
7    public long countCommas(long n) {
8        if(n<c1) return 0;
9
10        else if(n<c2) return n-c1 + 1;
11
12        else if(n<c3)return 2*(n-c2) + (c2-c1) + 2;
13
14        else if(n<c4) return 3*(n-c3) + 2*(c3-c2) + (c2-c1) + 3;
15
16        else if(n<c5) return 4*(n-c4)+3*(c4-c3) + 2*(c3-c2) + (c2-c1) + 4;
17
18        else if(n==c5) return 4*(n-c4)+3*(c4-c3) + 2*(c3-c2) + (c2-c1) + 5;
19
20        return -1;
21    }
22}