// Last updated: 29/09/2026, 19:31:01
1class Solution {
2    public int countMatchingSubarrays(int[] nums, int[] pattern) {
3        int n=nums.length;
4        int m=pattern.length;
5        
6        int i=0;
7        int j=i+m;
8
9        int count=0;
10        while(j<n){
11            boolean ans=true;
12            for(int k=0;k<m;k++){
13                int idx1=i+k;
14                int idx2=i+k+1;
15
16                if(pattern[k]==1){
17                    ans=(nums[idx1]<nums[idx2])?true:false;
18                }else if(pattern[k]==0){
19                    ans=(nums[idx1]==nums[idx2])?true:false;
20                }else{
21                    ans=(nums[idx1]>nums[idx2])?true:false;
22                }
23
24                if(!ans) break;
25            }
26            if(ans) count++;
27            i++;
28            j++;
29        }
30        return count;
31    }
32}