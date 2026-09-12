// Last updated: 12/09/2026, 13:15:00
1class Solution {
2    public int subarraysDivByK(int[] nums, int k) {
3        int n=nums.length;
4        
5        int [] rem=new int[k];
6        rem[0]=1;
7
8        int ans=0;
9        int prefix=0;
10
11        for(int i=0;i<n;i++){
12            prefix+=nums[i];
13
14            int remender=(( prefix % k) + k ) % k;
15
16            ans+=rem[remender];
17            rem[remender]++;
18            
19        }
20        return ans;
21    }
22}