// Last updated: 12/04/2026, 10:35:13
1class Solution {
2    public int[] findDegrees(int[][] mat) {
3        int n=mat.length;
4
5        int[] ans=new int[n];
6
7        for(int i=0;i<n;i++){
8            for(int j=0;j<n;j++){
9                if(mat[i][j]==1){
10                    ans[i]++;
11                }
12            }
13        }
14
15        return ans;
16        
17    }
18}