// Last updated: 23/09/2026, 20:18:04
1class Solution {
2    public boolean check(int[] piles,int h,int k){
3        int hours=0;
4        for(int i=0;i<piles.length;i++){
5            hours+=piles[i]/k;
6
7            if(piles[i]%k!=0) hours++;
8
9            if(hours>h) return false;
10        }
11
12        return hours<=h;
13    }
14    public int minEatingSpeed(int[] piles, int h) {
15        int max=0;
16        for(int i=0;i<piles.length;i++){
17            max=Math.max(max,piles[i]);
18        }
19
20        int low=1;
21        int high=max+1;
22
23        int min=Integer.MAX_VALUE;
24        while(low<=high){
25            int mid=low+(high-low)/2;
26            if(check(piles,h,mid)){
27                min=mid;
28                high=mid-1;
29            }else{
30                low=mid+1;
31            }
32        }
33        return min;
34    }
35}