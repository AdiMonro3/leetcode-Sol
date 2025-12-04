// Last updated: 04/12/2025, 14:22:42
1class Solution {
2    int dp[][];
3    public int helper(int [] arr,int i,int j){
4        if(j-i==1) return 0;
5        if(dp[i][j]!=-1) return dp[i][j];
6        int ans=Integer.MAX_VALUE;
7        for(int k=i+1;k<j;k++){
8            int cut=arr[j]-arr[i]+helper(arr,i,k)+helper(arr,k,j);
9            ans=Math.min(ans,cut);
10        }
11        return dp[i][j]=ans;
12    }
13    public int minCost(int n, int[] cuts) {
14        int m=cuts.length;
15        int [] arr=new int[m+2];
16        int x=arr.length;
17        arr[0]=0;
18        arr[arr.length-1]=n;
19        for(int i=1;i<x-1;i++){
20            arr[i]=cuts[i-1];
21        }
22        Arrays.sort(arr);
23        dp=new int[x][x];
24        for(int i=0;i<x;i++){
25            for(int j=0;j<x;j++){
26                dp[i][j]=-1;
27            }
28            
29        }
30        return helper(arr,0,x-1);
31
32    }
33}