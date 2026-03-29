// Last updated: 29/03/2026, 11:15:47
1class Solution {
2    public int minAbsoluteDifference(int[] nums) {
3        int l1=-1;
4        int l2=-1;
5
6        int ans=Integer.MAX_VALUE;
7
8        for(int i=0;i<nums.length;i++){
9            if(nums[i]==1){
10                l1=i;
11                if(l2!=-1){
12                    ans=Math.min(ans,Math.abs(i-l2));
13                }
14            }
15            else if(nums[i]==2){
16                l2=i;
17                if(l1!=-1){
18                    ans=Math.min(ans,Math.abs(i-l1));
19                }
20            }
21        }
22        return ans==Integer.MAX_VALUE?-1:ans;
23    }
24}