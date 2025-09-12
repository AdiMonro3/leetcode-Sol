// Last updated: 13/09/2025, 01:47:48
class Solution {
    public static int helper(int nums[],int k){
        if(nums.length==k){
            int ans=0;
            for(int i=0;i<nums.length;i++){
                ans+=nums[i];
            }
            return ans;
        }
        int i=k-1;
        int j=nums.length-1;
        int score=0;
        int leftsum=0;
        int rightsum=0;
        for(int z=0;z<k;z++){
            leftsum+=nums[z];
        }
        score=leftsum;
        while(i>=0){
            leftsum-=nums[i];
            rightsum+=nums[j];
            int currscore=leftsum+rightsum;
            score=Math.max(score,currscore);
            i--;
            j--;
        }
        return score;
    }
    public int maxScore(int[] cardPoints, int k) {

        return  helper(cardPoints,k);
    }
}