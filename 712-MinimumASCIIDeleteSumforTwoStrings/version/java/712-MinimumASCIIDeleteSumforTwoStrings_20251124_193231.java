// Last updated: 24/11/2025, 19:32:31
class Solution {
    int [][] dp;
    public int helper(String s1,String s2,int n,int m,int i,int j){
        if(i>=n && j>=m){
            return 0;
        }

        if(i>=n && j<m){
            int count=0;
            while(j<m){
                count+=(int)s2.charAt(j);
                j++;
            }
            return count;
        }
        if(j>=m && i<n){
            int count=0;
            while(i<n){
                count+=(int)s1.charAt(i);
                i++;
            }
            return count;
        }

        if(dp[i][j]!=-1) return dp[i][j];

        int sum=0;
        if(s1.charAt(i)==s2.charAt(j)){
            sum+=helper(s1,s2,n,m,i+1,j+1);
        }else{
            sum+=Math.min((int)s1.charAt(i)+helper(s1,s2,n,m,i+1,j),(int)s2.charAt(j)+helper(s1,s2,n,m,i,j+1));
        }

        return dp[i][j]=sum;

    }
    public int minimumDeleteSum(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        dp=new int [n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(s1,s2,n,m,0,0);
    }
}