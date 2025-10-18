// Last updated: 18/10/2025, 14:22:17
class Solution {
    public int helper(int matrix[][],int n,int m,int i,int j,int sqr){
        int rowlen=i+sqr;
        int collen=j+sqr;
        if(rowlen>n || collen>m) return 0;
        int ans=0;
        for(int x=i;x<i+sqr;x++){
            for(int y=j;y<j+sqr;y++){
                ans+=matrix[x][y];
            }
        }
        if(ans==sqr*sqr){
            return 1+helper(matrix,n,m,i,j,sqr+1);
        }
        return 0;
    }
    public int countSquares(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==1){
                   ans+=1+helper(matrix,n,m,i,j,2);
                }
            }
        }
        return ans;
    }
}