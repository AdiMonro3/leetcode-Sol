// Last updated: 28/10/2025, 11:32:10
class Solution {
    class Pair{
        int row;
        int col;

        public Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int nearestExit(char[][] grid, int[] entrance) {
        int n=grid.length;
        int m=grid[0].length;
        int visited[][]=new int[n][m];

        Queue<Pair> q=new LinkedList<>();

        int initialRow=entrance[0];
        int initialCol=entrance[1];

        visited[initialRow][initialCol]=1;
        q.add(new Pair(initialRow,initialCol));

        int []rowDir={0,1,0,-1};
        int []colDir={1,0,-1,0};

        int minSteps=0;

        while(!q.isEmpty()){

            int size=q.size();

            for(int i=0;i<size;i++){
                Pair temp=q.poll();

                int row=temp.row;
                int col=temp.col;

                if((row == 0 || col == 0 || row == n - 1 || col == m - 1)
                    && !(row == initialRow && col == initialCol)) return minSteps;

                for(int j=0;j<4;j++){

                    int newRow=row+rowDir[j];
                    int newCol=col+colDir[j];

                    if(newRow<n && newCol<m && newRow>=0 && newCol>=0 && visited[newRow][newCol]==0 && grid[newRow][newCol]!='+'){
                        q.add(new Pair(newRow,newCol));
                        visited[newRow][newCol]=1;
                    }
                }
            }
            minSteps++;
        }

        return -1;
    }
}