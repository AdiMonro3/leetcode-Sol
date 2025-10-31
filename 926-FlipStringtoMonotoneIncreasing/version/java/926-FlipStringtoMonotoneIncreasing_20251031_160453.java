// Last updated: 31/10/2025, 16:04:53
class Solution {
    int [][] dp;
    public int helper(String s,int i,int prev){
        if(i>=s.length()) return 0;
        if(prev!=-1){
            if(dp[i][prev]!=-1) return dp[i][prev];
        }
        int flip=Integer.MAX_VALUE;
        int notflip=Integer.MAX_VALUE;
        if(s.charAt(i)=='0'){
            if(prev==0 || prev==-1){
                flip=1+helper(s,i+1,1);
                notflip=helper(s,i+1,0);
            }else{
                flip=1+helper(s,i+1,1);
            }
        }
        else{
            if(prev==0 || prev==-1){
                flip=1+helper(s,i+1,0);
                notflip=helper(s,i+1,1);
            }else{
                notflip=helper(s,i+1,1);
            }
        }
        if(prev!=-1){
            dp[i][prev]=Math.min(flip,notflip);
        }
       return  Math.min(flip,notflip);
    }
    public int minFlipsMonoIncr(String s) {
        int n=s.length();
        dp=new int[n][2];
        for(int i=0;i<n;i++){
            dp[i][0]=-1;
            dp[i][1]=-1;
        }
        return helper(s,0,-1);
    }
}