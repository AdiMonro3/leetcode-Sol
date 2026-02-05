// Last updated: 05/02/2026, 13:53:06
1class Solution {
2    int[][] dp;
3    int n;
4    int m;
5    int []dr={-1,0,1,0};
6    int []dc={0,1,0,-1};
7    public int helper(int[][] mat,int i,int j){
8        // if(i<0 || j<0 || i>=n|| j>=m) return 0;
9        if(dp[i][j]!=-1) return dp[i][j];
10        int max=Integer.MIN_VALUE;
11        for(int k=0;k<4;k++){
12            int newr=i+dr[k];
13            int newc=j+dc[k];
14            int temp=1;
15            if(newr>=0 && newc>=0 && newr<n && newc<m && mat[newr][newc]>mat[i][j]){
16                temp+=helper(mat,newr,newc);
17            }
18            max=Math.max(max,temp);
19        }
20        return dp[i][j]=max;
21    }
22    public int longestIncreasingPath(int[][] matrix) {
23        n=matrix.length;
24        m=matrix[0].length;
25        dp=new int[n][m];
26
27        for(int i=0;i<n;i++){
28            Arrays.fill(dp[i],-1);
29        }
30        int result=Integer.MIN_VALUE;
31        for(int i=0;i<n;i++){
32            for(int j=0;j<m;j++){
33                result=Math.max(result,helper(matrix,i,j));
34            }
35        }
36        return result;
37    }
38}