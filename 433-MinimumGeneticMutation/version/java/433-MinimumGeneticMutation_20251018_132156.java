// Last updated: 18/10/2025, 13:21:56
class Solution {
    int dp[];
    public int helper(String s,int n,HashSet<String> set,int i){
        if(i>=n) return 0;
        if (dp[i] != -1) return dp[i];
        int ans=1+helper(s,n,set,i+1);
        for(int j=i+1;j<=n;j++){
            String temp=s.substring(i,j);
            if(set.contains(temp)){
                ans=Math.min(ans,helper(s,n,set,j));
            }
        }
        return  dp[i] = ans;

    }
    public int minExtraChar(String s, String[] dictionary) {
        int n=s.length();
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<dictionary.length;i++){
            set.add(dictionary[i]);
        }
        dp=new int[n];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        return helper(s,n,set,0);
    }
}