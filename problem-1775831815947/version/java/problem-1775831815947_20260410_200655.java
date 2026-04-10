// Last updated: 10/04/2026, 20:06:55
1class Solution {
2    public long helper(int[] nums,int[] cost,int target){
3        long sum=0;
4        for(int i=0;i<nums.length;i++){
5            sum+=(long)Math.abs(nums[i]-target)*cost[i];
6        }
7        return sum;
8    }
9    public long minCost(int[] nums, int[] cost) {
10        int n=nums.length;
11
12        int min =Integer.MAX_VALUE;
13        int max =Integer.MIN_VALUE;
14
15        for(int x : nums){
16            min=Math.min(min,x);
17            max=Math.max(max,x);
18        }
19
20        int low=min;
21        int high=max;
22
23        long ans =0;
24
25        while(low<high){
26            int mid=(low+high)/2;
27
28            long s1=helper(nums,cost,mid);
29            long s2=helper(nums,cost,mid+1);
30
31            ans=Math.min(s1,s2);
32
33            if(s1<s2){
34                high=mid;
35            }else{
36                low=mid+1;
37            }
38        }
39
40        return ans;
41        
42    }
43}