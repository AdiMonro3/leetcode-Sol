// Last updated: 26/01/2026, 22:38:05
1class Solution {
2    int [][] dp;
3    int OFFSET;
4    public int solve(int[] nums,int target,int sum,int i){
5        if(i>=nums.length ){
6            if(sum==target) return 1;
7            else return 0;
8        }
9         if (dp[i][sum + OFFSET] != Integer.MIN_VALUE) {
10            return dp[i][sum + OFFSET];
11        }
12
13        int pos=solve(nums,target,sum+nums[i],i+1);
14        int neg=solve(nums,target,sum-nums[i],i+1);
15
16        dp[i][sum + OFFSET] = pos + neg;
17        return dp[i][sum + OFFSET];
18
19    }
20    public int findTargetSumWays(int[] nums, int target) {
21        int n = nums.length;
22        int total = 0;
23        for (int x : nums) total += x;
24
25        OFFSET = total;
26        dp = new int[n][2 * total + 1];
27
28        for (int i = 0; i < n; i++) {
29            Arrays.fill(dp[i], Integer.MIN_VALUE);
30        }
31
32        return solve(nums, target, 0, 0);
33        // int total=0;
34        // for(int i=0;i<nums.length;i++){
35        //     total+=nums[i];
36        // }
37        // int [][] dp= new int[nums.length+1][total+1];
38        // for(int i=0;i<nums.length+1;i++){
39        //     dp[i][0]=1;
40        // }
41        // for(int idx=1;idx<nums.length+1;idx++){
42        //     for(int tar=0;tar<total+1;tar++){
43        //         int notpick=dp[idx-1][tar];
44        //         int pick=0;
45        //         if(tar>=nums[idx-1]){
46        //             pick=dp[idx-1][tar-nums[idx-1]];
47        //         }
48        //         dp[idx][tar]=pick+notpick;
49        //     }
50        // }
51        // int count=0;
52        // for(int j=0;j<total+1;j++){
53        //     int s1=j;
54        //     int s2=total-j;
55        //     if(s1-s2==target) count+=dp[nums.length][j];
56        // }
57        // return count;
58    }
59}