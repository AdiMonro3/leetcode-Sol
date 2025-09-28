// Last updated: 28/09/2025, 15:01:15
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
    public int minCost(int x, int[] cuts) {
        int m=cuts.length;
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(0);
        for(int i=0;i<m;i++){
            arr.add(cuts[i]);
        }
        arr.add(x);
        int n=arr.size();
        Collections.sort(arr);
        dp=new int[n][n]; 
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         dp[i][j]=-1;
        //     }
        // }
        // return helper(arr,0,n-1);
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<n;j++){
                int len=Integer.MAX_VALUE;
                for(int k=i+1;k<j;k++){
                    int  ben=arr.get(j)-arr.get(i)+helper(arr,i,k)+helper(arr,k,j);
                    len=Math.min(len,ben);
                
                }
                dp[i][j]=len;
            }
        }
    return dp[0][n-1];

    }
}