// Last updated: 07/10/2025, 10:17:27
class Solution {
    int dp[][];
    public boolean helper(String s,String p,int i,int j){
        if(i<0 && j<0) return true;
        if(j<0 && i>=0) return false;
        if(i<0 && j>=0){
            while(j>=0){
                if(p.charAt(j)!='*') return false;
                j=j-2;
            }
            return true;
        }
        if(dp[i][j]!=-1){
           if(dp[i][j]==1) return true;
           else return false;
        }
        boolean ans=false;
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'){
            ans=helper(s,p,i-1,j-1);
        }
        else if(p.charAt(j)=='*'){
            if(s.charAt(i)==p.charAt(j-1) || p.charAt(j-1)=='.'){
                ans=helper(s,p,i-1,j) | helper(s,p,i,j-2);
            }
            else if(s.charAt(i)!=p.charAt(j-1) || p.charAt(j-1)!='.'){
               ans= helper(s,p,i,j-2);
            }
        }
        if(ans==true){
            dp[i][j]=1;
        }
        else{
            dp[i][j]=0;
        }
        return ans;
    }
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return helper(s,p,n-1,m-1);
    }
}