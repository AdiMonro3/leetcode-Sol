// Last updated: 31/10/2025, 16:32:28
// DP solution (Space limit)
// class Solution {
//     public int minFlipsMonoIncr(String s) {
//         int n=s.length();
//         Integer[][] dp = new Integer[n+1][n+1];
//         return solve(s, 0, n-1, dp);
//     }
//     private int solve(String s, int l, int r, Integer[][] dp){
//         if(l>=r) return 0;
//         if(dp[l][r]!=null) return dp[l][r];
//         if(s.charAt(l)=='0') return dp[l][r] = solve(s, l+1, r, dp);
//         else if(s.charAt(r)=='1') return dp[l][r] = solve(s, l, r-1, dp);
//         return dp[l][r] = 1+Math.min(solve(s,l+1,r, dp), solve(s,l,r-1, dp));
//     }
// }

class Solution {
    public int minFlipsMonoIncr(String s) {
        int flips = 0, n=s.length(), ones=0;
        for(char c:s.toCharArray()){
            if(c=='1') ones++;
            else flips = Math.min(flips+1, ones);
        }
        return flips;
    }
}