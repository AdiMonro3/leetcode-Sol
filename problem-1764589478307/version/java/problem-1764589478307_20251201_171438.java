// Last updated: 01/12/2025, 17:14:38
1class Solution {
2    public boolean possible(int  n,long mid,long usuable){
3        // min number of minutes needed to run computers simultaneously
4        long need=n*mid;
5        if(usuable<need){
6            return false;
7        }
8        return true;
9    }
10    public long maxRunTime(int n, int[] batteries) {
11        long result=0;
12        long totalbattery=0;
13        for(int i=0;i<batteries.length;i++){
14            totalbattery+=batteries[i];
15        }
16        // batteries can provide maxmimum minutes to run ncomputers maxmin/n
17        long high=totalbattery/n;
18
19        long low=0;
20        while(low<=high){
21            long mid=(low+high)/2;
22            long usuable=0;
23            for(int i=0;i<batteries.length;i++){
24                usuable+=Math.min(batteries[i],mid);
25            }
26            if(possible(n, mid, usuable)){
27                result=mid;
28                low=mid+1;
29            }
30            else{
31                high=mid-1;
32            }
33        }
34        return result;
35
36    }
37}