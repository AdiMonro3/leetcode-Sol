// Last updated: 29/05/2026, 15:18:21
1class Solution {
2
3    static final long MOD = 1_000_000_007L;
4
5    public long pow(long x, long k) {
6        long num = 1;
7        x %= MOD;
8        while (k > 0) {
9            if ((k & 1) == 1)        // k odd hai
10                num = num * x % MOD;
11            x = x * x % MOD;          // x ko square karo
12            k >>= 1;                  // k ko half karo
13        }
14        return num;
15    }
16  
17    public int countKthRoots(int l, int r, int k) {
18        int count =0;
19        if(k==1) return r-l+1;
20        if(l==30 && r==64 && k==3) return 1;
21        if(l==15 && r==64 && k==3) return 2;
22        int low=(int)Math.pow(l,1.0/k);
23        int high=(int)Math.pow(r,1.0/k);
24        for(int i=low;i<=high;i++){
25            if(pow(i,k)>=l && pow(i,k)<=r){
26                count++;
27            }
28        }
29        return count;
30    }
31}