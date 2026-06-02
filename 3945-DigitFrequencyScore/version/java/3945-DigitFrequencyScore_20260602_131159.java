// Last updated: 02/06/2026, 13:11:59
1class Solution {
2    public int digitFrequencyScore(int n) {
3        HashMap<Integer,Integer> map=new HashMap<>();
4
5        while(n!=0){
6            int x=n%10;
7            n=n/10;
8            map.put(x,map.getOrDefault(x,0)+1);
9        }
10
11        int ans=0;
12        for(int temp:map.keySet()){
13            ans+=temp*map.get(temp);
14        }
15
16        return ans;
17
18    }
19}