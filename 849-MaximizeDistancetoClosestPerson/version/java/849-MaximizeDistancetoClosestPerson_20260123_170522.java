// Last updated: 23/01/2026, 17:05:22
1class Solution {
2    public int maxDistToClosest(int[] seats) {
3        int n=seats.length;
4        List<Integer> l=new ArrayList<>();
5        for(int i=0;i<n;i++){
6            if(seats[i]==1) l.add(i);
7        }
8        for(int i=0;i<n;i++){
9            if(seats[i]==0){
10                seats[i]=Integer.MAX_VALUE;
11                for(int j=0;j<l.size();j++){
12                    int diff=Math.abs(i-l.get(j));
13                    seats[i]=Math.min(seats[i],diff);
14                }
15            }
16        }
17        int max=Integer.MIN_VALUE;
18        for(int i=0;i<n;i++){
19            max=Math.max(max,seats[i]);
20        }
21        return max;
22    }
23}