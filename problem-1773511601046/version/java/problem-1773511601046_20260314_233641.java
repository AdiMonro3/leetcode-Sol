// Last updated: 14/03/2026, 23:36:41
1class Solution {
2    public int minCost(int[] nums1, int[] nums2) {
3        int n=nums1.length;
4
5        HashMap<Integer,Integer> map=new HashMap<>();
6
7        for(int x:nums1){
8            map.put(x, map.getOrDefault(x, 0) + 1);
9        }
10        for(int x:nums2){
11            map.put(x, map.getOrDefault(x, 0) - 1);
12        }
13
14        int extra=0;
15        for(int temp:map.values()){
16            if(temp%2!=0){
17                return -1;
18            }
19
20            extra+=Math.abs(temp)/2;
21        }
22        return extra/2;
23    }
24}