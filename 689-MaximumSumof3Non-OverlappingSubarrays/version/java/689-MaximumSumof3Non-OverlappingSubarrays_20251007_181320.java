// Last updated: 07/10/2025, 18:13:20
class Solution {
     int[][] dp;
    public int sum(int [] nums,int i,int j){
        int sum=0;
        while(i<j){
            sum+=nums[i];
            i++;
        }
        return sum;
    }
    public int solve(int [] nums,int n,int k,int count ,int i){
        if(count==3) return 0;
        if(i+k>n) return Integer.MIN_VALUE;
        if (dp[i][count] != Integer.MIN_VALUE) return dp[i][count];
        int pick=sum(nums,i,i+k)+solve(nums,n,k,count+1,i+k);
        int notpick=solve(nums,n,k,count,i+1);
        return dp[i][count] = Math.max(pick, notpick);
    }
    public void helper(int []nums,int n,int k,int count,int i,ArrayList<Integer>ans){
        if(count==3) return ;
        if(i+k>n) return ;
        
        int pick=sum(nums,i,i+k)+solve(nums,n,k,count+1,i+k);
        int notpick=solve(nums,n,k,count,i+1);
        if(pick>=notpick){
            ans.add(i);
            helper(nums,n,k,count+1,i+k,ans);
        }else{
            helper(nums,n,k,count,i+1,ans);
        }

    }
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n=nums.length;
        dp = new int[n + 1][4];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MIN_VALUE);
        ArrayList<Integer> ans=new ArrayList<>();
        helper(nums,n,k,0,0,ans);
        int arr[]=new int[3];
        for(int i=0;i<3;i++){
            arr[i]=ans.get(i);
        }
        return arr;
    }
}