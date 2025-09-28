// Last updated: 28/09/2025, 14:36:37
class Solution {
    public int [][] dp;
    public int helper(ArrayList<Integer> arr,int i,int j){
        if(j-i==1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int len=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int  ben=arr.get(j)-arr.get(i)+helper(arr,i,k)+helper(arr,k,j);
            len=Math.min(len,ben);
           
        }
        return dp[i][j]=len;
    }
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(0);
        for(int i=0;i<m;i++){
            arr.add(cuts[i]);
        }
        arr.add(n);
        int x=arr.size();
        Collections.sort(arr);
        dp=new int[x][x]; 
        for(int i=0;i<x;i++){
            for(int j=0;j<x;j++){
                dp[i][j]=-1;
            }
        }
        return helper(arr,0,arr.size()-1);

    }
}