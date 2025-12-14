// Last updated: 14/12/2025, 12:32:47
1class Solution {
2    int n;
3    int totalSeats;
4    int MOD=  1_000_000_007;
5    public int numberOfWays(String corridor) {
6        n=corridor.length();
7        List<Integer> seatidx=new ArrayList<>();
8        for(int i=0;i<n;i++){
9            if(corridor.charAt(i)=='S'){
10                seatidx.add(i);
11                totalSeats++;
12            }
13        }
14        if(totalSeats==0) return 0;
15        if(totalSeats==2) return 1;
16        if(totalSeats%2!=0) return 0;
17        long ways=1;
18        for(int i=1;i<seatidx.size()-1;i+=2){
19            int left=seatidx.get(i);
20            int right=seatidx.get(i+1);
21
22            int temp=right-left;
23
24            ways=(ways*temp)%MOD;
25        }
26        return (int)ways;
27    }
28}