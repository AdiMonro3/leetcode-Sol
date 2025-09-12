// Last updated: 13/09/2025, 01:49:01
class Solution {
    public static void bfs(int [][] isConnected,int [] visited,int node){
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        visited[node]=1;
        while(!q.isEmpty()){
            int temp=q.poll();
            for(int i=0;i<isConnected[0].length;i++){
                if(isConnected[temp][i]==1 && visited[i]==0){
                    q.add(i);
                    visited[i]=1;
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int[]visited=new int[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                count++;
                bfs(isConnected,visited,i);
            }
        }
        return count;
    }
}