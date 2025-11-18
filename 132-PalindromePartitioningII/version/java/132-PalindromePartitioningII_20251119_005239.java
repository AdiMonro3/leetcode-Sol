// Last updated: 19/11/2025, 00:52:39
class Solution {
     Integer[] dp;
    public boolean isPalindrom(String s,int start,int end){
        int i=start;
        int j=end;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public int helper(String s, int start){
        if(start == s.length()) return 0;
        if(isPalindrom(s,start,s.length()-1)) return 0;
        if(dp[start] != null) return dp[start];
        int min=Integer.MAX_VALUE;
     
        for(int i=start;i<s.length();i++){
            int temp=Integer.MAX_VALUE;
            if(isPalindrom(s,start,i)){
                 temp=1+helper(s,i+1);
                min=Math.min(temp,min);
            }
            min=Math.min(temp,min);
            
        }
        return dp[start] = min;
    }
    public int minCut(String s) {
         dp = new Integer[s.length()];
         return helper(s,0);
    }
}