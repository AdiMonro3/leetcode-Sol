// Last updated: 19/11/2025, 19:43:03
class Solution {
    int dp[][];
    boolean helper(String s,String p,int i,int j){
        if(i<0 && j<0) return true;
        if(i<0 && j>=0){
            while(j>=0){
                if(p.charAt(j)!='*') return false;
                j--;
            }
            return true;
        }
        if(i>=0 && j<0) return false;

        if(dp[i][j]!=-1){

            if(dp[i][j]==1) return true;
            
            return false;
        }
        boolean ans=false;

        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            ans=helper(s,p,i-1,j-1);
        }

        if(p.charAt(j)=='*'){
            ans=helper(s,p,i-1,j)|| helper(s,p,i-1,j-1) || helper(s,p,i,j-1);
        }

        if(ans){
            dp[i][j]=1;
        }else{
            dp[i][j]=0;
        }
        return ans;
        
    }
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        dp=new int[n][m];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return helper(s,p,n-1,m-1);
    }
}