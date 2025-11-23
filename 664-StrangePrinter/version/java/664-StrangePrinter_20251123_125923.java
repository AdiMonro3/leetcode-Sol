// Last updated: 23/11/2025, 12:59:23
class Solution {
    public int solve(String s,int i,int j,int[][] memo){
        if(i==j) return 1;
        if(i>j) return 0;
        if (memo[i][j] != 0) return memo[i][j];

        int minturn = 1 + solve(s, i + 1, j,memo);

        for(int k=i+1;k<=j;k++){
            if(s.charAt(i)==s.charAt(k)){
                int turn=solve(s,i,k-1,memo)+solve(s,k+1,j,memo);
                minturn=Math.min(minturn,turn);
            }
        }
       return memo[i][j] = minturn;
    }
    public int strangePrinter(String s) {
        int i=0;
        int j=s.length()-1;
        int [][]memo=new int[s.length()][s.length()];
        return solve(s,i,j,memo);
    }
}