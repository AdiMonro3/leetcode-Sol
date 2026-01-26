// Last updated: 26/01/2026, 21:25:26
1class Solution {
2    int dp[][];
3    public boolean findout(int []nums,int target,int i){
4        if(target==0) return true;
5        if(i>=nums.length || target<0) return false;
6        if(dp[target][i]!=-1){
7            if(dp[target][i]==1){
8                return true;
9            }
10            return false;
11        }
12        boolean pick=findout(nums,target-nums[i],i+1);
13        boolean nonpick=findout(nums,target,i+1);
14
15        if(pick || nonpick){
16            dp[target][i]=1;
17        }else{
18            dp[target][i]=0;
19        }
20
21        return pick || nonpick;
22    }
23    public boolean canPartition(int[] nums) {
24       int sum=0;
25        for(int i=0;i<nums.length;i++){
26            sum+=nums[i];
27        }
28        if(sum%2!=0) return false;
29        dp=new int[sum][nums.length];
30        for(int i=0;i<sum;i++){
31            for(int j=0;j<nums.length;j++){
32                dp[i][j]=-1;
33            }
34        }
35        return findout(nums,sum/2,0);
36    }
37}