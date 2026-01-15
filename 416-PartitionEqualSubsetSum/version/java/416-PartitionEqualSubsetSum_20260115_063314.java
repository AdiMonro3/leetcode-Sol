// Last updated: 15/01/2026, 06:33:14
1class Solution {
2    int dp[][];
3    public boolean findout(int []nums,int sum,int target,int i){
4        if(i>=nums.length || sum>target)return false;
5        if(dp[sum][i]!=-1){
6            if(dp[sum][i]==1) return true;
7
8            return false;
9        }
10        if(sum==target) return true;
11        boolean pick=findout(nums,sum+nums[i],target,i+1);
12        boolean notpick=findout(nums,sum,target,i+1);
13        if(pick==true || notpick==true){
14            dp[sum][i]=1;
15        }
16        else{
17            dp[sum][i]=0;
18        }
19
20        return pick||notpick;
21    }
22    public boolean canPartition(int[] nums) {
23        int sum=0;
24        for(int i=0;i<nums.length;i++){
25            sum+=nums[i];
26        }
27        if(sum%2!=0) return false;
28        dp=new int[sum][nums.length];
29        for(int i=0;i<sum;i++){
30            for(int j=0;j<nums.length;j++){
31                dp[i][j]=-1;
32            }
33        }
34        return findout(nums,0,sum/2,0);
35    }
36}